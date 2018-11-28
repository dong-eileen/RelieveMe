<template>
<div class="rating-display">
  <b>{{ calculateRating(numPositiveRating, numPositiveRating + numNegativeRating).toFixed(0) }}% Positive</b>
  <br>
  <button class="button is-primary" v-on:click="upvote()" :disabled="voted">
      <b-loading :is-full-page="false" :active.sync="upvoteIsLoading" :can-cancel="false"></b-loading>
      <svgicon class="happy-poo" icon="happy-poo" width="20" height="20" focusable="false" original></svgicon>
            <b> {{ numPositiveRating }} </b>
    </button>
    <button class="button is-black" v-on:click="downvote()" :disabled="voted">
      <b-loading :is-full-page="false" :active.sync="downvoteIsLoading" :can-cancel="false"></b-loading>
      <svgicon class="sad-poo" icon="sad-poo" width="20" height="20" focusable="false" original></svgicon>
            <b> {{ numNegativeRating }} </b>
    </button>
</div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'RatingDisplay',
  props: {
    origNumNegativeRating: {
      type: Number,
      default: 0
    },
    origNumPositiveRating: {
      type: Number,
      default: 0
    },
    bathroomId: {
      type: Number
    }
  },
  data () {
    // TODO: get num-positve and num-negative rating from backend database
    return {
      numNegativeRating: this.origNumNegativeRating,
      numPositiveRating: this.origNumPositiveRating,
      voted: false,
      upvoteIsLoading: false,
      downvoteIsLoading: false
    }
  },
  methods: {
    calculateRating: function (positive, total) {
      if (total === 0) {
        return 0
      }
      return positive / total * 100
    },
    upvote: function () {
      this.upvoteIsLoading = true
      axios
        .post('/api/bathroom/' + this.bathroomId + '/increasePositiveRating')
        .then(response => {
          this.numPositiveRating++
          this.upvoteIsLoading = false
        })
      this.voted = true
    },
    downvote: function () {
      this.downvoteIsLoading = true
      axios
        .post('/api/bathroom/' + this.bathroomId + '/increaseNegativeRating')
        .then(response => {
          this.numNegativeRating++
          this.downvoteIsLoading = false
        })
      this.voted = true
    }
  }
}
</script>
