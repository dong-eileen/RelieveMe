<template>
  <div class="hello">
    <div>
     <img src="../assets/logo.png" align="middle">
    </div>
    <search-bar class="halfwidth"></search-bar>
  </div>
</template>

<script>
import SearchBar from './SearchBar.vue'
export default {
  name: 'HelloWorld',
  components: {
    SearchBar
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.halfwidth {
  width: 70%;
  display: inline-block;
}
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
