import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
// 导入组件相关样式
import 'element-ui/lib/theme-chalk/index.css';
Vue.config.productionTip = false

// 配置Element插件
Vue.use(ElementUI)
new Vue({
  render: h => h(App),
}).$mount('#app')
