import Vue from "vue";
import VueRouter from "vue-router";

// import { component } from "vue/types/umd";

// 自定义路由组件
const LoginPage = () => import("@/views/loginPage.vue");
const indexPage = () => import("@/views/indexPage.vue");
const BookPage = () => import("@/views/bookPage.vue");
const ResetPasswordndexPage = () => import("@/views/register-resetpwd/resetPassword.vue");
const RegisterPage = () => import("@/views/register-resetpwd/registerPage.vue");


// 自定义路由数组
const routes = [
    // 登录路由
    {
        name: "index",
        path: "/",
        component: indexPage,
        children: [
            {
                name: "login",
                path: "/login",
                component: LoginPage,
                children: [
                    {
                        name: "reset",
                        path: "/login/reset",
                        component: ResetPasswordndexPage
                    },
                    {
                        name: "register",
                        path: "/login/register",
                        component: RegisterPage
                    }
                ]
            },
            {
                name: "book",
                path: "/",
                component: BookPage,
                children: [
                    
                ]
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