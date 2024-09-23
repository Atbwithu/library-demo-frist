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
              <div>
                <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" style="width: 100%;"
                  class="demo-ruleForm">
                  <el-form-item  prop="account">
                    <el-input type="primary" v-model="ruleForm.account" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item label="" prop="pass">
                    <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
                  </el-form-item>
                  <el-form-item>
                    <el-button type="primary" @click="submitForm('ruleForm')" >登录</el-button>
                    <el-button @click="resetForm('ruleForm')">重置</el-button>
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
export default {
  data() {
    var checkAge = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('账号不能为空'));
      }
      setTimeout(() => {
        if (!Number.isInteger(value)) {
          callback(new Error('请输入账号'));
        }
      }, 1000);
    };
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass');
        }
        callback();
      }
    };
    return {
      userimg: "https://th.bing.com/th/id/OIP.VnqbqHI999-VVVkUOWBcMwAAAA?w=163&h=180&c=7&r=0&o=5&pid=1.7",
      ruleForm: {
        pass: '',
        account: ''
      },
      rules: {
        pass: [
          { validator: validatePass, trigger: 'blur' }
        ],
        account: [
          { validator: checkAge, trigger: 'blur' }
        ]
      }
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