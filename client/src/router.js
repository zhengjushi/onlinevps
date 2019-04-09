import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home'
import Main from './components/v_main'

Vue.use(Router)

export default new Router({
  mode: 'hash',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      children: [
        {
          path: 'main',
          name: 'main',
          component: Main
        },
        {
          path: 'v_css',
          name: 'vcss',
          component: () => import('./components/v_css/index')
        },
        {
          path: 'v_html',
          name: 'vhtml',
          component: () => import('./components/v_html')
        },
        {
          path: 'v_js',
          name: 'vjs',
          component: () => import('./components/v_js')
        },
        {
          path: 'v_examination',
          name: 'vexamination',
          component: () => import('./components/v_examination')
        },
        {
          path: 'v_doc',
          name: 'vdoc',
          component: () => import('./components/v_doc/index'),
          children: [
            {
              path: '/v_htmldoc',
              name: 'vHtmlDoc',
              component: () => import('./components/v_doc/V_htmlDoc')
            },
            {
              path: '/v_cssdoc',
              name: 'vcssDoc',
              component: () => import('./components/v_doc/V_cssDoc')
            },
            {
              path: '/v_jsdoc',
              name: 'vjsDoc',
              component: () => import('./components/v_doc/V_jsDoc')
            }
          ]
        },
        {
          path: '*',
          component: () => import('./views/Error')
        }
      ]
    }
  ]
})
