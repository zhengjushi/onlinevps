<template>
  <div class="sidebar">
    <el-menu class="sidebar-el-menu" :default-active="onRoutes" :collapse="collapse" background-color="#049EFF"
             text-color="white" active-text-color="pink" unique-opened router>
      <template v-for="item in items">
        <template v-if="item.subs">
          <el-submenu :index="item.index" :key="item.index">
            <template slot="title">
              <i :class="item.icon"></i><span slot="title">{{ item.title }}</span>
            </template>
            <template v-for="subItem in item.subs">
              <el-submenu v-if="subItem.subs" :index="subItem.index" :key="subItem.index">
                <template slot="title">{{ subItem.title }}</template>
              </el-submenu>
              <el-menu-item v-else :index="subItem.index" :key="subItem.index">
                <i :class="subItem.icon"></i><span slot="title">{{ subItem.title }}</span>
              </el-menu-item>
            </template>
          </el-submenu>
        </template>
        <template v-else>
          <el-menu-item :index="item.index" :key="item.index">
            <i :class="item.icon"></i><span slot="title">{{ item.title }}</span>
          </el-menu-item>
        </template>
      </template>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: 'SideBar',
  data () {
    return {
      collapse: false,
      items: [
        {
          icon: 'el-icon-menu',
          index: 'main',
          title: '系统首页'
        },
        {
          icon: 'el-icon-edit-outline',
          index: 'v_html',
          title: 'HTMl模块'
        },
        {
          icon: 'el-icon-edit-outline',
          index: 'v_css',
          title: 'CSS模块'
        },
        {
          icon: 'el-icon-edit-outline',
          index: 'v_js',
          title: 'JS模块'
        },
        {
          icon: 'el-icon-edit-outline',
          index: 'v_examination',
          title: '题目模块'
        },
        {
          icon: 'el-icon-document',
          index: '5',
          title: '文档',
          subs: [
            {
              icon: 'el-icon-tickets',
              index: 'v_htmldoc',
              title: 'HTML文档'
            },
            {
              icon: 'el-icon-tickets',
              index: 'v_cssdoc',
              title: 'CSS文档'
            },
            {
              icon: 'el-icon-tickets',
              index: 'v_jsdoc',
              title: 'JS文档'
            },
            {
              icon: 'el-icon-tickets',
              index: 'v_exampledoc',
              title: '题目'
            }
          ]
        }
      ]
    }
  },
  computed: {
    onRoutes () {
      return this.$route.path.replace('/', '')
    }
  }
}
</script>

<style scoped lang="stylus">
  .sidebar
    position fixed
    height 100%
    left 0
  .sidebar::-webkit-scrollbar
    width: 0
  .sidebar-el-menu:not(.el-menu--collapse)
    width: 170px
  .sidebar > ul
    height: 100%
  .el-submenu .el-menu-item
    min-width 0
  .el-submenu__title
    padding 0 !important
  .el-menu-item [class^=el-icon-]
    color aqua
  .el-submenu [class^=el-icon-]
    color aqua
</style>
