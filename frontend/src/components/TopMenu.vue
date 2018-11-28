<template>
<nav class="navbar is-fixed-top is-primary" role="navigation" aria-label="main navigation">
  <div class="container">
  <div class="navbar-brand">
  <router-link class="navbar-item" :to="{name: 'HelloWorld'}">Home</router-link>
  <router-link class="navbar-item" :to="{name: 'BuildingList'}">Buildings</router-link>
  <router-link class="navbar-item" :to="{name: 'Feedback'}">Report a problem</router-link>
  <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false">
  <span aria-hidden="true"></span>
  <span aria-hidden="true"></span>
  <span aria-hidden="true"></span>
</a>
  </div>
<div class="navbar-menu">
  <div class="navbar-end">
  <div class="navbar-item"><search-bar></search-bar></div>
  </div>
</div>
</div>
</nav>
</template>

<script>
import SearchBar from './SearchBar.vue'
export default {
  name: 'TopMenu',
  components: {
    SearchBar
  }
}
</script>
