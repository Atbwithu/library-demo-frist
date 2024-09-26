import Vue from 'vue'
import App from './App.vue'
//异步请求
import axios  from 'axios'
//引入路由组件
import router from "./router/index.js"
// 导入饿了么组件相关样式
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';
// 导入懒加载组件
import VueLazyload from 'vue-lazyload'
import store from './store/index';

Vue.config.productionTip = false
Vue.prototype.$url="http://localhost:8082"
// 配置Element插件
Vue.use(ElementUI)
Vue.prototype.$axios= axios
Vue.prototype.$url=""

//配置懒加载组件
Vue.use(VueLazyload, {
  preLoad: 1.3,
  error: 'dist/error.png',
  loading: 'dist/loading.gif',
  attempt: 1
});

new Vue({
  VueLazyload,
  axios,
  router,
  store,
  render: h => h(App),
}).$mount('#app')
