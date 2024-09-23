import Vue from 'vue'
import App from './App.vue'
import axios  from 'axios'
import router from "./router/index.js"
import ElementUI from 'element-ui'
// 导入组件相关样式
import 'element-ui/lib/theme-chalk/index.css';
Vue.config.productionTip = false

// 配置Element插件
Vue.use(ElementUI)
Vue.prototype.$axios= axios
Vue.prototype.$url=""
new Vue({
  axios,
  router,
  render: h => h(App),
}).$mount('#app')
