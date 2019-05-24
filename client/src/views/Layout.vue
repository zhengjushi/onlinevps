<template>
 <div class="layouts">
    <nav-top />
    <div class="container-fluid">
      <div class="row flex-xl-nowrap2">
        <nav-left class="bd-sidebar col-md-3 col-xl-2 col-12"/>
        <div class="bd-content col-md-9 col-xl-10 col-12 pb-md-3 pl-md-5">
          <router-view />
        </div>
      </div>
    </div>
 </div>
</template>

<script>
import NavTop from './NavTop'
import NavLeft from './NavLeft'
export default {
  name: 'Layout',
  components: {
    NavTop,
    NavLeft
  }
}
</script>

<style scoped lang="stylus">
  .layouts
    height 100%
    width 100%
    .container-fluid
      overflow hidden
      margin-top 70px
      .bd-sidebar
        position fixed
        overflow auto
        z-index 1000
        height calc(100vh - 3rem)
        text-align center
        padding 0
      .bd-content
        margin-left 250px
        overflow auto
</style>
