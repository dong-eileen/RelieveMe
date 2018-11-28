<template>
  <div class="columns">
    <div class="column is-2" id="filter-sidebar">
      <b-field id="region-filter" class="left" label="Filter by region:"></b-field>
      <div class="field left"
           v-for="region in regions"
             :value="region.regionId"
             :key="'region' + region.regionId">
          <b-checkbox @input="calculateFilters()" v-model="filters.selectedRegions"
                      :native-value="region.regionId">
            {{ region.name }}
          </b-checkbox>
        </div>
      <br>

      <b-field id="accessibility-filter" class="left" label="Filter by restroom accessibility:"></b-field>
      <div class="field left"
           v-for="accessibility in accessibilities"
           :value="accessibility.id"
           :key="'accessibility' + accessibility.id">
        <b-checkbox @input="calculateFilters()" v-model="filters.selectedAccessibilities"
                    :native-value="accessibility.id">
          {{ accessibility.name }}
        </b-checkbox>
      </div>
    </div>

    <div class="column is-10" id="building-list">
      <h1 class="title is-2">All Buildings</h1>
      <b-table :data="filteredBuildings"
               :loading="loading"
               paginated
               per-page="10"
               default-sort="name"
      >
        <template slot-scope="filteredBuildings">
          <b-table-column field="properName" label ="Name" sortable>
            <router-link :to="{name: 'Building', params:{name: filteredBuildings.row.properName}}">
              {{filteredBuildings.row.properName}}
            </router-link>
          </b-table-column>
          <b-table-column field="region.name" label ="Region" sortable>
            {{filteredBuildings.row.region.name}}
          </b-table-column>
        </template>
      </b-table>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'BuildingList',
  data () {
    return {
      genderNeutralType: 2, // gender-neutral restrooms in backend gender type == 2
      filters: {
        selectedRegions: [],
        selectedAccessibilities: []
      },
      allBuildings: [],
      columns: [{
        field: 'properName',
        label: 'Name'
      },
      {
        field: 'region.name',
        label: 'Region'
      }],
      loading: false,
      regions: [],
      accessibilities: [
        {id: 0, name: 'Wheelchair accessible'},
        {id: 1, name: 'Gender-neutral'}
      ],
      filteredBuildings: []
    }
  },
  methods: {
    getAllBuildings: function () {
      this.loading = true
      axios
        .get(`/api/buildings`)
        .then(response => {
          this.loading = false
          this.allBuildings = response.data
          this.filteredBuildings = this.allBuildings
        })
    },
    getAllRegions: function () {
      axios
        .get('/api/regions')
        .then(response => {
          this.regions = this.regions.concat(response.data)
          // select all regions by default
          this.filters.selectedRegions = this.regions.map(function (region) { return region.regionId })
        })
    },
    calculateFilters: function () {
      this.filteredBuildings = this.allBuildings.filter(this.filterAll, this)
    },
    filterAll: function (building) {
      return this.filterBuildingsByRegion(building) && this.filterBuildingsByRestroomAccessibility(building)
    },
    filterBuildingsByRegion: function (building) {
      // return all given buildings if no region filter is selected; or return buildings in the selected region
      return this.filters.selectedRegions.includes(Number(building.region.regionId))
    },
    filterBuildingsByRestroomAccessibility: function (building) {
      // return all given buildings if no accessibility filter is selected;
      // or return all buildings that contain bathrooms with the chosen attributes
      for (var filterInd = 0; filterInd < this.filters.selectedAccessibilities.length; filterInd++) {
        if (!this.buildingContainsAccessibility(building, this.filters.selectedAccessibilities[filterInd])) {
          return false
        }
      }
      return true
    },
    buildingContainsAccessibility: function (building, accessibility) {
      // look at each floor in the building, each bathroom on the floor, and check if it has the accessibility option
      for (var floorInd = 0; floorInd < building.floors.length; floorInd++) {
        if (this.floorContainsAccessibility(building.floors[floorInd], accessibility)) {
          return true
        }
      }
      return false
    },
    floorContainsAccessibility: function (floor, accessibility) {
      for (var bathroomInd = 0; bathroomInd < floor.bathrooms.length; bathroomInd++) {
        if (this.bathroomHasAccessibility(floor.bathrooms[bathroomInd], accessibility)) {
          return true
        }
      }
      return false
    },
    bathroomHasAccessibility: function (bathroom, accessibility) {
      if (Number(accessibility) === 0) {
        return bathroom.wheelchairAccessible
      } else if (Number(accessibility) === 1) {
        return Number(bathroom.genderType) === this.genderNeutralType
      }
    }
  },
  mounted: function () {
    this.getAllBuildings()
    this.getAllRegions()
  }
}
</script>

<style scoped>
.left {
  text-align: left;
}
</style>
