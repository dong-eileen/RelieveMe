<template>
  <div id ="building-floor-plan">
    <h1 class="title is-2">{{$route.params.name}} Floor Plan</h1>

    <div v-for="plan in plans" v-bind:key="plan.floorPlanKey.floorNumber">
      <h2 class="subtitle is-3">
        <a target="_blank" v-bind:href="plan.link">Floor {{plan.floorPlanKey.floorNumber}} </a>
      </h2>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'BuildingFloorPlans',
  data () {
    return {
      plans: []
    }
  },
  methods: {
    getFloorPlans: function () {
      axios
        .get('/api/buildings/' + this.$route.params.name + '/floorplans')
        .then(response => {
          this.plans = response.data
        })
    }
  },
  mounted: function () {
    this.getFloorPlans()
  }
}
</script>

<style>
</style>
