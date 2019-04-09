<template>
  <div>
  <el-card shadow="hover" style="height:335px;">
    <div slot="header" class="clearfix">
      <span>语言详情</span>
    </div>
    Vue
    <el-progress :percentage="71.3" color="#42b983"></el-progress>
    JavaScript
    <el-progress :percentage="24.1" color="#f1e05a"></el-progress>
    CSS
    <el-progress :percentage="3.7"></el-progress>
    HTML
    <el-progress :percentage="0.9" color="#f56c6c"></el-progress>
  </el-card>
  </div>
</template>

<script>
export default {
  name: 'mains'
}
</script>

<style scoped lang="stylus">
  .content
    display flex
    align-items center
    height 100px
</style>
