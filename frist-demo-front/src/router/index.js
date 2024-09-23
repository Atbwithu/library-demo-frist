import Vue from "vue";
import VueRouter from "vue-router";
// import { component } from "vue/types/umd";

// 自定义路由组件
const LoginPage = () => import ("@/views/loginPage.vue");
const indexPage = () => import ("@/views/indexPage.vue");

// 自定义路由数组
const routes = [
    // 登录路由
    {
        name: "index",
        path: "/",
        component: indexPage ,
        children:[
            {
                name: "login",
                path: "/login",
                component: LoginPage , 
            }
        ]
    }
]
Vue.use(VueRouter);

const router = new VueRouter({
    mode: "history",
    routes
});

export default router