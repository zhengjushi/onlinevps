<template>
  <div class="error">
    <img :src="imgUrl" alt="">
  </div>
</template>

<script>
export default {
  name: 'Error',
  data () {
    return {
      imgUrl: require('../assets/img/404.jpg')
    }
  }
}
</script>
<style scoped lang="stylus">
  .error
    width 100%
    height 100%
    overflow hidden
    img
      width 100%
      height 100%
      overflow hidden
</style>
