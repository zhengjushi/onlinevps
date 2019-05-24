<template>
        <b-card-group>
          <b-card header="文档">
          <b-list-group v-for="item in list" :key="item.id">
            <b-list-group-item
              class="item-bottom"
              href="#"
            >
              {{item.name}}
            </b-list-group-item>
          </b-list-group>
        </b-card>
      </b-card-group>
</template>

<script>
export default {
  name: 'NavLeft',
  data () {
    return {
      list: []
    }
  },
  created () {
    this.getList()
  },
  methods: {
    findAllList (url) {
      this.axios.get(`/${url}/findAll`)
        .then(res => {
          this.list = res.data.data
          console.log(this.list)
        })
        .catch(err => {
          console.log(err)
        })
    },
    getList () {
      const url = 'html'
      this.findAllList(url)
    }
  }
}
</script>

<style scoped lang="stylus">
    .item-bottom
        margin-bottom 5px
</style>
