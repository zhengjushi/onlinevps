<template>
  <div class="bg">
    <img :src="imgUrl" alt="">
  </div>
</template>

<script>
export default {
  name: 'mains',
  data () {
    return {
      imgUrl: require('../../assets/img/bg.jpg')
    }
  }
}
</script>

<style scoped lang="stylus">
  .bg
    display flex
    justify-content center
    align-items  center
    padding 0 !important
    width 100%
    height 100%
    overflow hidden
</style>
