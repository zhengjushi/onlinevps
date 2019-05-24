<template>
  <div class="header">
    <div class="logo">
      <img :src="imgUrl" alt="">
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      imgUrl: require('../assets/img/webLogo.jpg')
    }
  }
}
</script>
<style scoped lang="stylus">
  .header
    width 100%
    height 55px !important
    color #fff
    background-color #049EFF
    position fixed
    z-index 99
    .logo
      margin 0 auto
      width 170px
      height 55px
      padding-left  10px
      img
        width 100%
        height 100%
</style>
