<template>
    <div class="form-container">
      <el-form
        class="form_container"
        :ref="formData"
        :rules="rules"
        :label-position="labelPosition"
        label-width="70px"
        :model="formData">
        <div class="Form">
          <el-form-item label="试卷ID" prop="eid">
            <el-input v-model="formData.eId"></el-input>
          </el-form-item>
          <el-form-item label="题目" prop="qquestion">
            <el-input v-model="formData.qQuestion"></el-input>
          </el-form-item>
          <el-form-item label="选项A" prop="qa">
            <el-input v-model="formData.qA"></el-input>
          </el-form-item>
          <el-form-item label="选项B" prop="qb">
            <el-input v-model="formData.qB"></el-input>
          </el-form-item>
          <el-form-item label="选项C" prop="qc">
            <el-input v-model="formData.qC"></el-input>
          </el-form-item>
          <el-form-item label="选项D" prop="qd">
            <el-input v-model="formData.qD"></el-input>
          </el-form-item>
          <el-form-item label="答案" prop="qanswer">
            <el-input v-model="formData.qAnswer"></el-input>
          </el-form-item>
          <el-button class="btn" plain type="primary" @click="submitForm(formData)">提交</el-button>
        </div>
      </el-form>
    </div>
</template>

<script>
export default {
  name: 'V_examination',
  data () {
    return {
      labelPosition: 'bottom',
      rules: {
        eid: [{ required: true, message: '请输入试卷名', trigger: 'blur' }],
        qquestion: [{ required: true, message: '请输入题目', trigger: 'blur' }],
        qa: [{ required: true, message: '请输入选项', trigger: 'blur' }],
        qb: [{ required: true, message: '请输入选项', trigger: 'blur' }],
        qc: [{ required: true, message: '请输入选项', trigger: 'blur' }],
        qd: [{ required: true, message: '请输入选项', trigger: 'blur' }],
        qanswer: [{ required: true, message: '请输入答案', trigger: 'blur' }]
      },
      formData: {
        qQuestion: '',
        qA: '',
        qB: '',
        qC: '',
        qD: '',
        qAnswer: '',
        eId: ''
      }
    }
  },
  methods: {
    submitForm (form) {
      this.axios.post('/examQuestion/insertOne', form)
        .then(data => {
          // 添加成功
          this.$message({
            message: data.data.msg,
            type: 'success'
          })
        }).catch(() => {
          this.$message({
            message: '添加失败',
            type: 'error'
          })
        })
    }
  }
}
</script>

<style scoped lang="stylus">
  .el-form-item__label
    padding 0
  .el-button--primary.is-plain
    width 100% !important
  .el-textarea__inner
    height 137px !important
  .form-container
    position relative
    width 100%
    height 100%
    .form_container
      width 560px
      height 250px
      position absolute
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
