// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import global_info from './components/js/global.js'
Vue.prototype.GLOBAL = global_info

import axios from 'axios'
Vue.prototype.$axios = axios

import iView from 'iview'
import 'iview/dist/styles/iview.css' // 使用 CSS
Vue.use(iView)

Vue.config.productionTip = false

import VueCookies from 'vue-cookies'
Vue.use(VueCookies)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
