<template>
  <div>
    <nav-top />
    <div class="main" style="margin-top: 70px">
      <edit-area />
    </div>
  </div>
</template>

<script>
import NavTop from '../../views/NavTop'
import EditArea from '../../commons/Edit'
export default {
  name: 'Main',
  components: { NavTop, EditArea }
}
</script>

<style lang='stylus' scoped>
  .home
    width 100%
    height 100%
</style>
