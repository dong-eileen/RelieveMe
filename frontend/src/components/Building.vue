<template>
  <div id ="building">
    <b-loading :is-full-page="false" :active.sync="isLoading" :can-cancel="false"></b-loading>
    <h1 class="title is-2">{{$route.params.name}}</h1>
    <router-link :to="{name: 'BuildingFloorPlans'}">Floor Plans</router-link>
    <b-tabs v-model="activeTab" @change="filterFloorsBySelectedTab()">
      <b-tab-item v-for="tab in tabs"
                  :key="'tab' + tab"
                  :label="tab"
      >
        <div v-for="floor in sortedFloorsList(filteredFloors)" v-bind:key="floor.number">
          <b-collapse v-if="filterBathroomsBySelectedTab(floor.bathrooms).length > 0"
                      class="card" :open.sync="floor.isOpen" >
            <div slot="trigger" class="card-header is-primary">
                <p class="card-header-title">
                    Floor {{floor.number}}
                </p>
                <a class="card-header-icon">
                    <b-icon
                        :icon="floor.isOpen ? 'angle-down' : 'angle-right'">
                    </b-icon>
                </a>
            </div>
            <div class="card-content tab-content">
                <div class="content">
                    <bathroom-panel
                      v-for="bathroom in sortedBathroomsList(filterBathroomsBySelectedTab(floor.bathrooms))"
                      :key="bathroom.bathroomId"
                      v-bind="bathroom"
                    ></bathroom-panel>
                </div>
            </div>
          </b-collapse>
        </div>
      </b-tab-item>
    </b-tabs>
  </div>
</template>

<script>
import axios from 'axios'
import BathroomPanel from './BathroomPanel.vue'

export default {
  name: 'Building',
  components: {
    'bathroom-panel': BathroomPanel
  },
  data () {
    return {
      menType: 0,
      womenType: 1,
      genderNeutralType: 2,
      name: '',
      floors: [],
      tabs: ['All', 'Men\'s', 'Women\'s', 'Gender-Neutral'],
      filteredFloors: [],
      activeTab: 0,
      isLoading: false
    }
  },
  methods: {
    getBuilding: function () {
      this.isLoading = true
      axios
        .get('/api/buildings/' + this.$route.params.name)
        .then(response => {
          this.floors = []
          response.data.floors.forEach(this.addFloor)
          this.filteredFloors = this.floors
          this.isLoading = false
        })
        .catch((err) => {
          this.floors = []
          this.filteredFloors = []
          console.error(err)
          this.isLoading = false
        })
    },
    makeFloor: function (floor) {
      var newFloor = {
        number: floor.floorKey.number,
        bathrooms: floor.bathrooms,
        isOpen: false
      }
      return newFloor
    },
    addFloor: function (floor) {
      this.floors.push(this.makeFloor(floor))
    },
    sortedFloorsList: function (floors) {
      return floors.slice().sort(function (floor1, floor2) {
        return floor1.number - floor2.number
      })
    },
    sortedBathroomsList: function (bathrooms) {
      return bathrooms.slice().sort(function (bathroom1, bathroom2) {
        return bathroom1.bathroomId - bathroom2.bathroomId
      })
    },
    filterBathroomsBySelectedTab: function (bathrooms) {
      if (this.activeTab === 0) {
        return bathrooms
      }
      // if we select a tab, then show all bathrooms that correspond to that tab, or gender-neutral bathrooms
      var filteredBathrooms = []
      for (var bathroomInd = 0; bathroomInd < bathrooms.length; bathroomInd++) {
        if (this.bathroomIsGender(bathrooms[bathroomInd], this.tabs[this.activeTab]) ||
            this.bathroomIsGender(bathrooms[bathroomInd], 'Gender-Neutral')) {
          filteredBathrooms.push(bathrooms[bathroomInd])
        }
      }
      return filteredBathrooms
    },
    filterFloorsBySelectedTab: function () {
      this.filteredFloors = this.floors.filter(this.filterFloorsByGender, this)
    },
    filterFloorsByGender: function (floor) {
      return this.activeTab === 0 ||
        this.floorContainsGender(floor, this.tabs[this.activeTab])
    },
    floorContainsGender: function (floor, gender) {
      for (var bathroomInd = 0; bathroomInd < floor.bathrooms.length; bathroomInd++) {
        if (this.bathroomIsGender(floor.bathrooms[bathroomInd], gender)) {
          return true
        }
      }
      return false
    },
    bathroomIsGender: function (bathroom, gender) {
      if (gender === 'Men\'s') {
        return Number(bathroom.genderType) === Number(this.menType)
      } else if (gender === 'Women\'s') {
        return Number(bathroom.genderType) === Number(this.womenType)
      } else if (gender === 'Gender-Neutral') {
        return Number(bathroom.genderType) === Number(this.genderNeutralType)
      }
    }
  },
  watch: {
    '$route': function (to, from) {
      this.getBuilding()
      this.activeTab = 0
    }
  },
  mounted: function () {
    this.getBuilding()
    this.activeTab = 0
  }
}
</script>

<style scoped>
  .tab-content {
    background-color: #eafaf5;
  }
</style>
