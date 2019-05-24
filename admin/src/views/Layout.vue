<template>
  <div class="wrapper">
    <v-head />
    <el-container>
      <el-aside width="200px"><v-sidebar /></el-aside>
      <el-main>
        <router-view></router-view>
       </el-main>
    </el-container>
  </div>
</template>

<script>
import vHead from './Header.vue'
import vSidebar from './Sidebar.vue'
export default {
  name: 'home',
  components: {
    vHead, vSidebar
  }
}
</script>
<style scoped lang="stylus">
  .wrapper
    height 100%
    .el-container
      height 100%
      .el-header
        padding 0
      .el-aside
        background-color #049EFF
        width: 170px !important
        margin-top 50px
      .el-main
        margin-top 50px
        padding 0 !important
</style>
