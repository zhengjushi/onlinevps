<template>
  <div>
    <v-curmbs>
      <el-breadcrumb-item slot="title">CSS模块</el-breadcrumb-item>
      <el-breadcrumb-item slot="details">CSS录入</el-breadcrumb-item>
    </v-curmbs>
    <div class="container">
      <div class="form-box">
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="表单名称">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item label="选择器">
            <el-select v-model="form.region" placeholder="请选择">
              <el-option key="bbk" label="步步高" value="bbk"></el-option>
              <el-option key="xtc" label="小天才" value="xtc"></el-option>
              <el-option key="imoo" label="imoo" value="imoo"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="日期时间">
            <el-col :span="11">
              <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
            </el-col>
            <el-col class="line" :span="2">-</el-col>
            <el-col :span="11">
              <el-time-picker placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>
            </el-col>
          </el-form-item>
          <el-form-item label="文本框">
            <el-input type="textarea" rows="5" v-model="form.desc"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">表单提交</el-button>
            <el-button>取消</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
import VCurmbs from '../v_crumbs'
export default {
  name: 'V_css',
  components: { VCurmbs },
  data () {
    return {
      form: {
        name: '',
        region: '',
        label: '',
        date1: '',
        date2: '',
        delivery: true,
        type: ['步步高'],
        resource: '小天才',
        desc: '',
        options: []
      }
    }
  }
}
</script>

<style scoped>

</style>
