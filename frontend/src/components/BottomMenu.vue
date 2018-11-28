<template>
<footer class="bottommenu is-fixed-bottom">
  <div class="container">
    <nav class="level">
      <div class="level-left">
  <p><router-link :to="{name: 'Feedback'}"><b-icon pack="fas" icon="envelope" size="is-small"></b-icon> &nbsp; Contact us</router-link> &nbsp;
  <a target="_blank" href="https://github.com/kburk1997/RelieveMe">
  <b-icon pack="fab" icon="github" size="is-small"></b-icon> &nbsp;
  GitHub</a></p>
  </div>
  </nav>
    Icons made by <a target="_blank" href="http://www.freepik.com" title="Freepik">Freepik</a> from <a target="_blank" href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a>
    <br>
    Icons made by <a target="_blank" href="https://www.flaticon.com/authors/those-icons" title="Those Icons">Those Icons</a> from <a target="_blank" href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a>
    <br>
    Icons made by <a target="_blank" href="https://www.flaticon.com/authors/catkuro" title="catkuro">catkuro</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a>
  </div>
</footer>
<!---->
</template>

<script>
export default {
  name: 'BottomMenu'
}
</script>

<style scoped>
.bottommenu {
  background-color: #fafafa;
  padding: 1%;
  position: relative;
  width: 100%;
  bottom: 0;
}
</style>
