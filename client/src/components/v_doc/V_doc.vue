<template>
  <div>
    <el-row type="flex" class="row_bg" justify="center">
      <el-col :span="8">
        <router-link to="v_htmldoc"><el-button type="success">HTML模块</el-button></router-link>
      </el-col>
      <el-col :span="8">
        <router-link to="v_cssdoc"><el-button type="success">CSS模块</el-button></router-link>
      </el-col>
      <el-col :span="8">
        <router-link to="v_jsdoc"><el-button type="success">JavaScript模块</el-button></router-link>
      </el-col>
      </el-row>
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'v_doc'
}
</script>

<style scoped lang="stylus">
  .row_bg
    margin 20px
    color #6f7180 !important
</style>
