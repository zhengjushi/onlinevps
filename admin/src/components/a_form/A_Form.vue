<template>
  <div class="form-container">
    <el-form
      class="form_container"
      :ref="formData"
      :rules="rules"
      :label-position="labelPosition"
      label-width="120px"
      :model="formData">
      <div class="Form">
        <el-form-item :label="label.Name" prop="name">
          <el-input v-model="formData.name"></el-input>
        </el-form-item>
        <el-form-item :label="label.Desc" prop="desc">
          <el-input v-model="formData.desc"></el-input>
        </el-form-item>
        <el-form-item :label="label.Example" prop="example">
          <el-input
            type="textarea"
            v-model="formData.example"
          ></el-input>
        </el-form-item>
        <el-button class="btn" plain type="primary" @click="submitForm(formData)">提交</el-button>
      </div>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'A_Form',
  props: { formData: Object, label: Object, options: String },
  data () {
    return {
      labelPosition: 'bottom',
      rules: {
        name: [{ required: true, message: '请输入标签名', trigger: 'blur' }],
        desc: [{ required: true, message: '请输入对应描述', trigger: 'blur' }],
        example: [{ required: true, message: '青输入案例', trigger: 'blur' }]
      }
    }
  },
  methods: {
    sendData (url, value) {
      this.$axios.post('/' + url + '/insertOne', value)
        .then(data => {
          // 添加成功
          this.$message({
            message: data.data.msg,
            type: 'success'
          })
          this.formData = ''
        }).catch(() => {
          this.$message({
            message: '添加失败',
            type: 'error'
          })
        })
    },
    submitForm (value) {
      this.$refs[value].validate((valid) => {
        if (valid) {
          const url = this.options
          switch (url) {
            case 'html':
              this.sendData(url, value)
              break
            case 'css':
              this.sendData(url, value)
              break
            case 'js':
              this.sendData(url, value)
              break
          }
        } else {
          return false
        }
      })
    }
  }
}
</script>

<style scoped lang="stylus">
  .el-button--primary.is-plain
      width 100% !important
  .el-textarea__inner
    height 137px !important
  .form-container
    position relative
    width 100%
    height 100%
    .el-form-item__label
      text-align left
    .form_container
      width 550px
      height 250px
      position absolute
      top 20%
      left 30%
      padding 20px
      border-radius 5px
      text-align center
      .Form
        margin-top 50px
        background-color #fff
        padding 20px 20px 20px 20px
        border-radius 5px
        box-shadow 0px 5px 10px #cccc
</style>
