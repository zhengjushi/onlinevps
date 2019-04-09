<template>
  <div>
    <v-table
      :list="list"
      :form="form"
      :dialog="dialog"
      >></v-table>
  </div>
</template>

<script>
import VTable from '../v_table'
export default {
  name: 'V_HtmlDoc',
  components: { VTable },
  data () {
    return {
      list: [ { name: '1', date: new Date().toLocaleDateString() } ],
      form: {},
      dialog: {}
    }
  }
}
</script>

<style scoped>

</style>
