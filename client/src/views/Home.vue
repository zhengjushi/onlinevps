<template>
  <div class="wrapper">
    <v-head></v-head>
    <v-sidebar></v-sidebar>
    <div class="rightContainer">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import vHead from './Header.vue'
import vSidebar from './Sidebar.vue'
export default {
  name: 'home',
  data () {
    return {
      tagsList: [],
      collapse: false
    }
  },
  components: {
    vHead, vSidebar
  }
}
</script>
<style scoped lang="stylus">
  .rightContainer
    position: relative
    top 0
    left 180px
    width calc(100% - 180px)
    height calc(100% - 64px)
    overflow auto
</style>
