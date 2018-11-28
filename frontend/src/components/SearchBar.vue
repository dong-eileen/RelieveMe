<template>
<b-field>
  <b-autocomplete ref="autocomplete" id="search-bar"
    v-model="searchTerm"
    :data="filteredDataArray"
    placeholder="Search for a building"
    @select="option => selected = option"
    icon="search"
    @keydown.native.enter.prevent="enterPressed()">
    <template slot="empty">No building found</template>
    <input type="submit" value="Submit">
  </b-autocomplete>
  </b-field>
</template>

<script>
import axios from 'axios'

export default {
  name: 'SearchBar',
  data () {
    return {
      buildings: [],
      properSearch: '',
      searchTerm: '',
      selected: null
    }
  },
  methods: {
    resetState: function () {
      this.searchTerm = ''
      this.selected = null
    },
    enterPressed: function () {
      var autocompleteComponent = this.$refs.autocomplete
      if (autocompleteComponent.hovered === null) {
        // make search request and clear & close the dropdown
        this.getBuilding()
        autocompleteComponent.isActive = false
        this.resetState()
      } else {
        // user is hovering over an option, choose the option
        autocompleteComponent.enterPressed()
      }
    },
    getBuilding: function () {
      axios
        .get('/api/buildings/' + this.searchTerm)
        .then(response => {
          this.properSearch = response.data.properName
          this.$router.push('/buildings/' + this.properSearch)
        })
    },
    getAllBuildings: function () {
      axios
        .get(`/api/buildings/buildingNames`)
        .then(response => { this.buildings = response.data })
    }
  },
  computed: {
    filteredDataArray () {
      return this.buildings.filter((option) => {
        return option
          .toString()
          .toLowerCase()
          .indexOf(this.searchTerm.toLowerCase()) >= 0
      })
    }
  },
  created: function () {
    this.getAllBuildings()
  }
}
</script>

<style scoped>
</style>
