<template>
  <div>
    <el-tag size="medium">jJavaScript模块</el-tag>
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
      options: 'js',
      label: {
        Name: 'JavaScript标签',
        Desc: '描述',
        Example: '案例'
      }
    }
  },
  methods: {
    submitForm (value) {},
    resetForm (value) {}
  }
}
</script>

<style scoped lang="stylus">
  .el-tag
    margin 10px
</style>
