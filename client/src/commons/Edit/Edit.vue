<template>
  <div>
    <b-button block variant="light" @click="getData">提交运行</b-button>
      <div id="core" class="core core_margin1">
        <div class="editorSet clearfix">
          <div>
            <div class="editor">
              <span class="label">html</span>
              <pre id="editor1" class="edit-area"></pre>
            </div>
            <div class="editor">
              <span class="label">css</span>
              <pre id="editor2" class="edit-area"></pre>
            </div>
            <div class="editor">
              <span class="label">javascript</span>
              <pre id="editor3" class="edit-area"></pre>
            </div>
            <div class="editor">
              <iframe style="top: 0;background: #fff;" class="edit-area" id="preview" frameborder="0" srcdoc="<!DOCTYPE html><html><head><meta charset=&quot;utf-8&quot; /><title>代码测试</title><meta http-equiv=&quot;Content-Type&quot; content=&quot;text/html; charset=utf-8&quot;/><meta name=&quot;format-detection&quot; content=&quot;telephone=no&quot; /><meta name=&quot;apple-mobile-web-app-status-bar-style&quot; content=&quot;black&quot; /><meta name=&quot;apple-mobile-web-app-capable&quot; content=&quot;yes&quot; /><meta http-equiv=&quot;X-UA-Compatible&quot; content=&quot;chrome=1,IE=edge&quot;/><meta name=&quot;viewport&quot; content=&quot;width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0&quot;/><style type=&quot;text/css&quot;></style><script type=&quot;text/javascript&quot; src=&quot;https://cdn.bootcss.com/vConsole/3.2.0/vconsole.min.js&quot;></script><script type=&quot;text/javascript&quot;>new window.VConsole();</script></head><body><script type=&quot;text/javascript&quot;></script></body></html>"></iframe>
            </div>
          </div>
        </div>
      </div>
    </div>
</template>

<script>
import ace from 'ace-builds'
import 'ace-builds/src-noconflict/ext-language_tools'
import 'ace-builds/webpack-resolver'
export default {
  name: 'Edit',
  data () {
    return {
      editor1: '',
      editor2: '',
      editor3: ''
    }
  },
  methods: {
    getData () {
      let htmlValue = this.editor1.getValue()
      let cssValue = this.editor2.getValue()
      let jsValue = this.editor3.getValue()
      if (htmlValue === '' && cssValue === '' && jsValue === '') {
        alert('请输入内容')
      } else {
        let htmlStr = '<!DOCTYPE html>' +
          '<html>' +
          '<head>' +
          '<meta charset="utf-8" />' +
          '<style type="text/css">' +
          cssValue +
          '</style>' +
          '</head>' +
          '<body>' +
          htmlValue +
          '<script type="text/javascript">' +
          jsValue +
          '</' +
          'script>' +
          '</body>' +
          '</html>'
        document.getElementById('preview').srcdoc = htmlStr
      }
    }
  },
  mounted () {
    this.editor1 = ace.edit('editor1', {
      theme: 'ace/theme/monokai',
      mode: 'ace/mode/html',
      wrap: true,
      autoScrollEditorIntoView: true,
      enableSnippets: true,
      enableLiveAutocompletion: true,
      enableBasicAutocompletion: true
    })
    this.editor2 = ace.edit('editor2', {
      theme: 'ace/theme/monokai',
      mode: 'ace/mode/css',
      wrap: true,
      autoScrollEditorIntoView: true,
      enableSnippets: true,
      enableLiveAutocompletion: true,
      enableBasicAutocompletion: true
    })
    this.editor3 = ace.edit('editor3', {
      theme: 'ace/theme/monokai',
      mode: 'ace/mode/javascript',
      wrap: true,
      autoScrollEditorIntoView: true,
      enableSnippets: true,
      enableLiveAutocompletion: true,
      enableBasicAutocompletion: true
    })
    document.getElementById('editor1').style.fontSize = '16px'
    document.getElementById('editor2').style.fontSize = '16px'
    document.getElementById('editor3').style.fontSize = '16px'
  }
}
</script>

<style scoped lang="stylus">
    .editorSet .editor
      height 450px
      width: 50%
      overflow-y hidden
      background-color rgb(44, 52, 55)
      float left
  .label
    background #b956bb
    height 20px
    padding 0 6px
    line-height 20px
    z-index 999
    text-align center
    font-size 16px
    color white
    border-radius 3px
  .editor iframe
    min-height 100px
    min-width 100px
    height 100%
    width 100%
  .edit-area
    height 85%
</style>
