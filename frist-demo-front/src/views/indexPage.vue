<template>
    <div id="box">
        <el-container>
            <el-header style="height: 100px;">
                <div id="headList">

                    <ul id="functionlist" style="width: 100%;height: 100pxs;">
                        <li>
                            <!-- 网页标题 -->
                            <span id="headTitle" @click="index()"> <router-link to="/"><i
                                        class="el-icon-collection"></i><b>马铃薯头书籍</b> </router-link></span>
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
                                        <router-link to="/login" style="text-decoration: none; color: black;">
                                            登录账号
                                        </router-link>
                                    </el-dropdown-item>
                                    <el-dropdown-item v-if="token"><span
                                            @click="getUserInfo()">个人信息</span></el-dropdown-item>
                                    <el-dropdown-item></el-dropdown-item>
                                    <el-dropdown-item v-if="token" icon="el-icon-plus"> <i
                                            @click="outLogin()">退出登录</i></el-dropdown-item>
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
        <el-dialog :visible.sync="dialogVisible" title="" style="width: 80%;  margin: 0 auto;">
            <el-card class="">
                <div style="float: right; width: 100%;">
                    <el-tabs v-model="activeName">
                        <el-tab-pane label="个人信息" name="first">
                            <el-form :model="user">
                                <el-form-item label="姓名">
                                    <el-input v-model="user.name" placeholder=""></el-input>
                                </el-form-item>
                                <!-- <el-form-item label="性别">
                                    <el-radio v-model="user.sex" label="男">男</el-radio>
                                    <el-radio v-model="user.sex" label="女">女</el-radio>
                                </el-form-item> -->
                                <el-form-item label="电子邮箱">
                                    <el-input v-model="user.email" placeholder=""></el-input>
                                </el-form-item>
                                <el-form-item label="账号">
                                    <el-input v-model="user.account" placeholder=""></el-input>
                                </el-form-item>
                                <el-form-item label="密码">
                                    <el-input v-model="user.password" placeholder=""></el-input>
                                </el-form-item>
                                <el-form-item label="备注">
                                    <el-input v-model="user.remake" type="textarea" placeholder=""></el-input>
                                </el-form-item>
                                <el-form-item label="">
                                    <el-button type="primary" round> <i class="el-icon-edit-outline"></i>保存</el-button>
                                </el-form-item>
                            </el-form>
                        </el-tab-pane>


                        <el-tab-pane label="个人头像" name="second">
                            <el-upload class="avatar-uploader" action="http://localhost:8082/info/uploadPicture"
                                :show-file-list="false" :on-success="handleAvatarSuccess"
                                :before-upload="beforeAvatarUpload">
                                <img v-if="imageUrl" :src="imageUrl" class="avatar">
                                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                            </el-upload>
                        </el-tab-pane>
                    </el-tabs>
                </div>
            </el-card>

        </el-dialog>
    </div>
</template>
<script>
import axios from 'axios';

export default {
    data() {

        return {
            activeName: 'first',
            imageUrl: '',
            dialogVisible: false,
            token: localStorage.getItem("token"),
            userimg: "https://th.bing.com/th/id/OIP.VnqbqHI999-VVVkUOWBcMwAAAA?w=163&h=180&c=7&r=0&o=5&pid=1.7",
            user: {}
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
        },
        getUserInfo(){
            
            axios({
                url:"http://localhost:8082/info/getUserInfo",
                method:"get"
            }).then((resp)=>{
                this.user=resp.data["data"]
                console.log(resp.data["data"]);
                
            })
            this.dialogVisible= true
        },
        outLogin() {
            localStorage.removeItem("token")

            this.$message({
                message: '退出成功',
                type: 'success'
            });
            location.reload()
        },
        handleAvatarSuccess(res, file) {
            this.imageUrl = URL.createObjectURL(file.raw);
        },
        beforeAvatarUpload(file) {
            const isJPG = file.type === 'image/jpeg';
            const isLt2M = file.size / 1024 / 1024 < 2;

            if (!isJPG) {
                this.$message.error('上传头像图片只能是 JPG 格式!');
            }
            if (!isLt2M) {
                this.$message.error('上传头像图片大小不能超过 2MB!');
            }
            return isJPG && isLt2M;
        }
    }

}

</script>
<style>
#box {
    display: flex;
    flex-direction: row-reverse;
    height: 1200px;
}

.el-header {
    /* background-color: aqua; */
    width: 100%;
    color: #333;
    flex: 1;
}

.el-main {
    background-color: #e0e0e0;
    /* height: 100%; */
    height: 1000px;
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

#functionlist {
    display: flex;
    height: 100px;
    justify-content: center;
    align-items: center;
}

ul:hover {
    /* background-color: #9e9999; */
}

/* 上传头像样式 */
.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
}

.avatar-uploader .el-upload:hover {
    border-color: #409EFF;
}

.avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
}

.avatar {
    width: 178px;
    height: 178px;
    display: block;
}
</style>