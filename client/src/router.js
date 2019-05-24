import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Layout'
import Main from './components/Main'

Vue.use(Router)

export default new Router({
  mode: 'hash',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      redirect: 'main'
    },
    {
      path: '/main',
      name: 'main',
      component: Main
    },
    {
      path: '/example',
      name: 'example',
      component: () => import('./components/Example')
    },
    {
      path: '/',
      name: 'home',
      component: Home,
      children: [
        {
          path: 'htmldoc',
          name: 'htmldoc',
          component: () => import('./components/HtmlDoc')
        },
        {
          path: 'cssdoc',
          name: 'cssldoc',
          component: () => import('./components/CSSDoc')
        },
        {
          path: 'jsdoc',
          name: 'jsdoc',
          component: () => import('./components/JSDoc')
        },
        {
          path: '*',
          component: () => import('./views/Error')
        }
      ]
    }
  ]
})
