'use strict'
import Vue from 'vue'
import axios from 'axios'
import qs from 'qs'
// 引入loading加载动画
import { Loading } from 'element-ui'

// Full config:  https://github.com/axios/axios#request-config
// axios.defaults.baseURL = process.env.baseURL || process.env.apiUrl || '';
// axios.defaults.headers.common['Authorization'] = AUTH_TOKEN;
// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
let config = {
  // baseURL: process.env.baseURL || process.env.apiUrl || ""
  // timeout: 60 * 1000, // Timeout
  // withCredentials: true, // Check cross-site Access-Control
  // 全局配置使用qs
  transformRequest: [(data) => {
    return qs.stringify({ ...data })
  }]
}

const _axios = axios.create(config)
// 自定义动画函数
let loading
let startLoading = () => {
  /* 开场动画 */
  loading = Loading.service({
    lock: true,
    text: '正在加载...客官请稍等...',
    background: 'rgba(0,0,0,.6)'
  })
}
let endLoading = () => {
  /* 结束动画 */
  loading.close()
}

// 设置请求拦截
_axios.interceptors.request.use(
  function (config) {
    // Do something before request is sent
    startLoading()
    return config
  },
  function (error) {
    // Do something with request error
    return Promise.reject(error)
  }
)

// 设置响应拦截
_axios.interceptors.response.use(
  function (response) {
    // Do something with response data
    endLoading()
    return response
  },
  function (error) {
    // Do something with response error
    endLoading()
    return Promise.reject(error)
  }
)

Plugin.install = function (Vue, options) {
  Vue.axios = _axios
  window.axios = _axios
  Object.defineProperties(Vue.prototype, {
    axios: {
      get () {
        return _axios
      }
    },
    $axios: {
      get () {
        return _axios
      }
    }
  })
}

Vue.use(Plugin)

export default Plugin
