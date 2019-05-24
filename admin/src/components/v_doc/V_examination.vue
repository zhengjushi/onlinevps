<template>
  <div>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="题目">
              <span>{{ props.row.qquestion }}</span>
            </el-form-item>
            <el-form-item label="选项A">
              <span>{{ props.row.qa }}</span>
            </el-form-item>
            <el-form-item label="选项B">
              <span>{{ props.row.qb }}</span>
            </el-form-item>
            <el-form-item label="选项C">
              <span>{{ props.row.qc }}</span>
            </el-form-item>
            <el-form-item label="选项D">
              <span>{{ props.row.qd }}</span>
            </el-form-item>
            <el-form-item label="答案">
              <span>{{ props.row.qanswer }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column
        label="试卷ID"
        prop="eid">
      </el-table-column>
      <el-table-column
        label="题目ID"
        prop="qid">
      </el-table-column>
      <el-table-column
        label="题目"
        prop="qquestion">
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
            @click="handleDelete(scope.row.qid)"
            circle
          >
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <a-pagination
      :paginations="paginations"
      @handleSizeChange="handleSizeChange"
      @handleCurrentChange="handleCurrentChange"
    />
    <el-dialog
      title="题目"
      :visible.sync="dialog.show"
      :close-on-click-modal='false'
      :close-on-press-escape='false'
      :modal-append-to-body="false">
      <div class="form">
        <el-form
          ref="form"
          :model="formData"
          label-width="120px"
          style="margin:10px;width:auto;">
          <el-form-item prop='ID' label="试卷EID">
            <el-input type="ID" v-model="formData.eId" disabled="disabled" />
          </el-form-item>
          <el-form-item prop='ID' label="题目ID">
            <el-input type="ID" v-model="formData.id" disabled="disabled" />
          </el-form-item>
          <el-form-item prop='ID' label="题目">
            <el-input type="ID" v-model="formData.qQuestion" />
          </el-form-item>
          <el-form-item prop='name' label="选项A">
            <el-input type="name" v-model="formData.qA"></el-input>
          </el-form-item>
          <el-form-item prop='desc' label="选项B">
            <el-input type="desc" v-model="formData.qB"></el-input>
          </el-form-item>
          <el-form-item prop='desc' label="选项C">
            <el-input type="desc" v-model="formData.qC"></el-input>
          </el-form-item>
          <el-form-item prop='desc' label="选项D">
            <el-input type="desc" v-model="formData.qD"></el-input>
          </el-form-item>
          <el-form-item prop='desc' label="答案">
            <el-input type="desc" v-model="formData.qAnswer"></el-input>
          </el-form-item>
          <el-form-item  class="text_right">
            <el-button @click="dialog.show = false">取 消</el-button>
            <el-button type="primary" @click='onSubmit(formData)'>提  交</el-button>
          </el-form-item>

        </el-form>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import APagination from '../a_pagination'
export default {
  name: 'examination',
  components: { APagination },
  data () {
    return {
      tableData: [],
      allTableData: [],
      formData: {
        id: '',
        qQuestion: '',
        qA: '',
        qB: '',
        qC: '',
        qD: '',
        qAnswer: '',
        eId: ''
      },
      dialog: { show: false },
      // 需要给分页组件传的信息
      paginations: {
        page_index: 1, // 当前位于哪页
        total: 0, // 总数
        page_size: 5, // 1页显示多少条
        page_sizes: [5, 10, 20, 30, 40], // 每页显示多少条
        layout: 'total, sizes, prev, pager, next, jumper' // 翻页属性
      }
    }
  },
  created () {
    this.getExample()
  },
  methods: {
    getExample () {
      this.axios.get('/examQuestion/findAll')
        .then(res => {
          const data = res.data.data
          this.allTableData = data
          this.setPaginations()
        })
    },
    setPaginations () {
      // 总页数
      this.paginations.total = this.allTableData.length
      this.paginations.page_index = 1
      this.paginations.page_size = 5
      // 设置默认分页数据
      this.tableData = this.allTableData.filter((item, index) => {
        return index < this.paginations.page_size
      })
    },
    /* 当前页的改变 */
    handleCurrentChange (page) {
      //  获取当前页
      let index = this.paginations.page_size * (page - 1)
      //  获取总数
      let nums = this.paginations.page_size * page
      let table = []
      for (let i = index; i < nums; i++) {
        if (this.allTableData[i]) {
          table.push(this.allTableData[i])
        }
      }
      this.tableData = table
    },
    /* 改变每页条数 */
    handleSizeChange (pageSizes) {
      this.paginations.page_size = 1
      this.paginations.page_size = pageSizes
      this.tableData = this.allTableData.filter((item, index) => {
        return index < pageSizes
      })
    },
    handleEdit (index, row) {
      this.dialog.show = true
      this.formData = {
        id: row.qid,
        eId: row.eid,
        qA: row.qa,
        qB: row.qb,
        qC: row.qc,
        qD: row.qd,
        qAnswer: row.qanswer,
        qQuestion: row.qquestion
      }
    },
    handleDelete (id) {
      this.$confirm('你确定要删除吗', '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios.delete(`/examQuestion/deleteOne/${id}`)
          .then(response => {
            this.$message({
              message: response.data.msg,
              type: 'success'
            })
            this.getExample()
          })
      })
    },
    onSubmit (form) {
      const id = form.id
      this.axios.post(`/examQuestion/updateOne/${id}`, form)
        .then(res => {
          this.$message({
            message: '数据更新成功',
            type: 'success'
          })
          this.dialog.show = false
          this.getExample()
        })
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
