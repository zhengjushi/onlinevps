<template>
    <b-navbar toggleable="lg" type="dark" variant="info" fixed="top">
      <b-navbar-brand to="/main">在线虚拟编程</b-navbar-brand>
      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
      <b-collapse id="nav-collapse" is-nav>
        <!-- 连接地址，后期需改动 todo -->
        <b-navbar-nav class="nav-center">
          <b-nav-item to="/main">首页</b-nav-item>
          <b-nav-item to="/htmldoc">HTML文档</b-nav-item>
          <b-nav-item to="/cssdoc">CSS文档</b-nav-item>
          <b-nav-item to="/jsdoc">JAVASCRIPT文档</b-nav-item>
          <b-nav-item to="/example">在线测试</b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
</template>

<script>
export default {
  name: 'NavTop'
}
</script>

<style scoped lang="stylus">
  .bg-light
    border-bottom 1px solid #ddd
  .nav-center
    text-align center
</style>
