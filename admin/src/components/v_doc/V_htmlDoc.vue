<template>
  <div>
    <el-tag size="medium" type="danger">HTML文档</el-tag>
    <a-table
      :tableData="tableData"
      :label="label"
      :options="options"
      @update="getFormDate"
    />
    <a-pagination
      :paginations="paginations"
      @handleSizeChange="handleSizeChange"
      @handleCurrentChange="handleCurrentChange"
    />
  </div>
</template>

<script>
import ATable from '../a_table'
import APagination from '../a_pagination'
export default {
  name: 'V_HtmlDoc',
  components: { ATable, APagination },
  data () {
    return {
      tableData: [],
      allTableData: [],
      options: 'html',
      label: {
        id: 'ID',
        name: 'HTMl标签名称',
        desc: '描述',
        cases: '案例'
      },
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
    this.getFormDate()
  },
  methods: {
    getFormDate () {
      this.$axios.get('/html/findAll')
        .then(res => {
          const data = res.data
          if (data.code === 0) {
            this.allTableData = data.data
            // 设置分页数据
            this.setPaginations()
          }
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
    }
  }
}
</script>

<style scoped lang="stylus">
  .el-tag
    margin 10px
</style>
