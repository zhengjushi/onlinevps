<template>
  <div>
    <el-tag size="medium">CSS模块</el-tag>
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
      options: 'css',
      label: {
        Name: 'css标签',
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
