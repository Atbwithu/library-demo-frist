<template>
  <div id="box">
    <el-container>
      <el-main>
        <div class="flex1">
          <div class="login-img"></div>
          <div class="login-form">
            <el-card class="box-card" style="width: 60%;">

              <div class="login-title">
                <h1 style="text-align: center;">账号登录</h1>
              </div>
              <div class="reset-register">
                <!-- 导航 -->
                <div class="guide">
                  <el-dialog title="" :visible.sync="dialogVisible" width="width">
                    <div>
                      <router-link to="/login/reset">
                        重置密码
                      </router-link>
                      <router-link to="/login/register">
                        注册
                      </router-link>
                    </div>
                    <div slot="footer">
                      <router-view></router-view>
                    </div>
                  </el-dialog>
                </div>
              </div>
              <div>
                <el-form :model="ruleForm" status-icon ref="ruleForm" style="width: 100%;" class="demo-ruleForm">
                  <el-form-item prop="account">
                    <el-input type="primary" v-model="ruleForm.account" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="" prop="pass">
                    <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item>
                    <el-button type="primary" @click="submitForm()">登录</el-button>
                    <el-button @click="resetForm('ruleForm')">重置</el-button>
                    <el-button @click="dialogVisible = true">账号问题</el-button>
                  </el-form-item>
                </el-form>
              </div>
            </el-card>
          </div>
        </div>
      </el-main>
    </el-container>
  </div>
</template>
<script>
import router from '@/router';
import axios from 'axios';
// const user ={}
export default {
  data() {

    return {
      userimg: "https://th.bing.com/th/id/OIP.VnqbqHI999-VVVkUOWBcMwAAAA?w=163&h=180&c=7&r=0&o=5&pid=1.7",
      dialogVisible: false,
      ruleForm: {
        password: '',
        account: ''
      }
    };
  },
  methods: {
    submitForm() {
      if (localStorage.getItem("token")) {
        this.$message({
          message: '您已登录，无需重复登录',
          type: 'warning'
        });
      } else {
        axios({
          url: "http://localhost:8082/enter/login",
          method: "POST",
          data: this.ruleForm
        }).then((resp) => {
          if (resp.data["code"] == 200) {

            this.$store.commit('userInfo', resp.data["data"])
            console.log(resp.data["data"]);
            localStorage.setItem("token", resp.data["message"])
            this.$message({
              message: '登录成功！欢迎您' + resp.data["data"].name,
              type: 'success'
            });
            router.push("/")
            setTimeout(() => {
            location.reload();
          }, 2000 + Math.random() * 500);
          } else {
            this.$message({
              message: '用户不存在或密码错误',
              type: 'error'
            });
          }
          
        })
      }

    }
  }
}

</script>
<style>
#box {
  display: flex;
  flex-direction: row-reverse;
}

.el-main {
  margin: 0 auto;
  background-color: #E9EEF3;
  height: 100%;
  color: #333;

  line-height: 160px;
  display: flex;
  justify-content: center;
  flex-direction: row;
  width: 80%;
}

.flex1 {
  height: 1000px;
  display: flex;
  flex: 1;
}

.login-img {
  flex: 2;
  border: 1px solid;
  background-image: url("D:\TestProject\SpringBoot\first-demo\library-demo-frist\frist-demo-front\src\assets\login-img.jpg");
  background-size: cover;
}

.login-form {
  flex-direction: column;
  display: flex;
  flex: 1;
  justify-content: center;
  align-items: center;

}
</style>