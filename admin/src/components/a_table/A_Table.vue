<template>
  <div>
    <el-table
      height="500"
      :data="tableData"
      style="width: 100%">
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="标签ID">
              <span>{{ props.row.id }}</span>
            </el-form-item>
            <br>
            <el-form-item label="标签名称">
              <span>{{ props.row.name }}</span>
            </el-form-item>
            <br>
            <el-form-item label="标签描述">
              <span>{{ props.row.desc }}</span>
            </el-form-item>
            <br>
            <el-form-item label="案例">
              <span>{{ props.row.example }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column
        :label="label.id"
        prop="id">
      </el-table-column>
      <el-table-column
        :label="label.name"
        prop="name">
      </el-table-column>
      <el-table-column
        :label="label.desc"
        prop="desc">
      </el-table-column>
      <el-table-column
        :label="label.cases"
        prop="example">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            type="primary"
            icon="el-icon-edit"
            @click="handleEdit(scope.$index, scope.row)"
            circle
          >
          </el-button>
          <el-button
            type="danger"
            icon="el-icon-delete"
            @click="handleDelete(scope.row.id)"
            circle
          >
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <a-dialog
      :dialog="dialog"
      :dialogForm="dialogForm"
      :options="options"
    />
  </div>
</template>

<script>
import ADialog from '../a_dialog'
export default {
  name: 'A_Table',
  components: { ADialog },
  props: { tableData: Array, label: Object, options: String },
  data () {
    return {
      dialog: { show: false, title: '', option: '' },
      dialogForm: {
        id: '',
        desc: '',
        name: '',
        example: ''
      }
    }
  },
  methods: {
    deleteData (url, row) {
      this.$confirm('你确定要删除吗', '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios.delete('/' + url + '/deleteOne' + '/' + row)
          .then(response => {
            this.$message({
              message: response.data.msg,
              type: 'success'
            })
            this.$emit('update')
          })
      })
    },
    handleEdit (index, row) {
      const ot = this.options
      // 编辑
      this.dialog = {
        show: true,
        title: '修改信息',
        option: ot
      }
      this.dialogForm = {
        id: row.id,
        name: row.name,
        desc: row.desc,
        example: row.example
      }
    },
    handleDelete (row) {
      // 判断点击的操作，选择对应接口
      const url = this.options
      switch (url) {
        case 'html':
          this.deleteData(url, row)
          break
        case 'css':
          this.deleteData(url, row)
          break
        case 'js':
          this.deleteData(url, row)
          break
        default:
          break
      }
    }
  }
}
</script>
<style>
  .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
</style>
