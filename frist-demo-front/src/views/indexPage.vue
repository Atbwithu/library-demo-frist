<template>
    <div id="box">
        <el-container>
            <el-header style="height: 100px;">
                <div id="headList">

                    <ul id="functionlist" style="width: 100%;height: 100pxs;">
                        <li>
                            <!-- 网页标题 -->
                            <span id="headTitle" @click="index()"><i class="el-icon-collection"></i><b>马铃薯头书籍</b> </span>
                        </li>
                        <li>
                            <el-link target="_blank">默认链接</el-link>
                        </li>
                        <li>
                            <el-link target="_blank">默认链接</el-link>
                        </li>
                        <li>
                            <el-link target="_blank">默认链接</el-link>
                        </li>
                        <li>
                            <!-- 用户头像展示 -->
                            <el-dropdown>
                                <span class="el-dropdown-link">
                                    <div class="demo-basic--circle">
                                        <div class="block"><el-avatar shape="square" :size="50"
                                                :src="userimg"></el-avatar></div>
                                    </div>
                                </span>
                                <!-- 个人信息功能操作 -->
                                <el-dropdown-menu slot="dropdown">
                                    <el-dropdown-item v-if="!token">
                                        <router-link to="/login">
                                            登录账号
                                        </router-link>
                                    </el-dropdown-item>
                                    <el-dropdown-item>个人信息</el-dropdown-item>
                                    <el-dropdown-item>退出登录</el-dropdown-item>
                                </el-dropdown-menu>
                            </el-dropdown>
                        </li>
                    </ul>
                </div>
            </el-header>
            <el-main>
                <router-view style="width: 100%;"></router-view>
            </el-main>
        </el-container>
    </div>
</template>
<script>
export default {
    data() {

        return {
            token: "",
            userimg: "https://th.bing.com/th/id/OIP.VnqbqHI999-VVVkUOWBcMwAAAA?w=163&h=180&c=7&r=0&o=5&pid=1.7",

        };
    },
    methods: {
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    alert('submit!');
                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        }
    }
}

</script>
<style>
#box {
    display: flex;
    flex-direction: row-reverse;
}

.el-header {
    /* background-color: aqua; */
    width: 100%;
    color: #333;
    flex: 1;
}

.el-main {
   height: 100%;
}

#headList {
    display: flex;
    margin: 0 auto;
    width: 50%;
    flex-direction: row;

}

#headTitle {
    text-align: center;
    font-size: 20px;
}

#functionlist li {

    text-align: center;
    margin: 0 auto;
    flex-direction: row;
    width: 80;
    display: inline-block;
    /* flex: 1; */
}

#functionlist li :hover {
    background-color: #bebbbb;
}

ul {
    display: flex;
    height: 100px;
    justify-content: center;
    align-items: center;
}

ul:hover {
    /* background-color: #9e9999; */
}



.login-title {}
</style>