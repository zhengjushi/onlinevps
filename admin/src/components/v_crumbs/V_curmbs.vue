<template>
  <div class="crumbs">
    <el-breadcrumb separator="/">
      <slot name="title"></slot>
      <slot name="details"></slot>
    </el-breadcrumb>
  </div>
</template>

<script>
export default {
  name: 'V_curmbs'
}
</script>

<style scoped>

</style>
