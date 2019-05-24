<template>
    <div class="logFund">
        <el-dialog
                :title="dialog.title"
                :visible.sync="dialog.show"
                :close-on-click-modal='false'
                :close-on-press-escape='false'
                :modal-append-to-body="false">
            <div class="form">
                <el-form
                        ref="form"
                        :model="dialogForm"
                        label-width="120px"
                        style="margin:10px;width:auto;">
                  <el-form-item prop='ID' label="ID">
                    <el-input type="ID" v-model="dialogForm.id" disabled="disabled" />
                  </el-form-item>
                  <el-form-item prop='name' label="名称">
                    <el-input type="name" v-model="dialogForm.name"></el-input>
                  </el-form-item>
                  <el-form-item prop='desc' label="描述">
                    <el-input type="desc" v-model="dialogForm.desc"></el-input>
                  </el-form-item>
                    <el-form-item label="example">
                      <el-input type="textarea" v-model="dialogForm.example"></el-input>
                    </el-form-item>
                      <el-form-item  class="text_right">
                        <el-button @click="dialog.show = false">取 消</el-button>
                        <el-button type="primary" @click='onSubmit(dialogForm)'>提  交</el-button>
                    </el-form-item>

                </el-form>
            </div>
        </el-dialog>
    </div>
</template>

<script>
export default {
  name: 'Dialog',
  inject: ['reload'],
  props: {
    // 通过属性传值的方式
    dialog: Object,
    dialogForm: Object,
    options: String
  },
  methods: {
    updateData (url, id, value) {
      // 判断点击的操作，选择对应接口
      this.$axios.post('/' + url + '/updateOne' + '/' + id, value)
        .then(response => {
          // 添加成功
          this.$message({
            message: '数据更新成功',
            type: 'success'
          })
          this.reload()
          this.dialog.show = false
        })
        .catch(error => {
          console.log(error)
        })
    },
    onSubmit (value) {
      const url = this.options
      const id = value.id
      console.log(value)
      switch (url) {
        case 'html':
          this.updateData(url, id, value)
          console.log(value)
          break
        case 'css':
          this.updateData(url, id, value)
          break
        case 'js':
          this.updateData(url, id, value)
          break
        default:
          break
      }
    }
  }
}
</script>

<style scoped>

</style>
