<template>
  <div>
    <el-tag size="medium">HTML模块</el-tag>
    <a-form :formData="formData" :label="label" :options="options" />
  </div>
</template>

<script>
import AForm from '../a_form'
export default {
  name: 'V_css',
  components: { AForm },
  data () {
    return {
      formData: {
        name: '',
        desc: '',
        example: ''
      },
      options: 'html',
      label: {
        Name: 'HTML标签',
        Desc: '描述',
        Example: '案例'
      }
    }
  }
}
</script>

<style scoped lang="stylus">
  .el-tag
    margin 10px
</style>
