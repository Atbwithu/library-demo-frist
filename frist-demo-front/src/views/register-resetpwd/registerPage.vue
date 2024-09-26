<template>
    <el-form :model="ruleForm" status-icon  ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="账号" >
            <el-input v-model.number="ruleForm.account"></el-input>
        </el-form-item>
        <el-form-item label="密码" >
            <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="姓名">
            <el-input type="password" v-model="ruleForm.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="register()">注册</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
</template>
<script>
import axios from 'axios';
export default {
    data() {
        return {
            ruleForm: {},
           
        }
    },
    methods: {
        register() {
            axios({
                url: this.$url + "http://localhost:8082/enter/register",
                method: "POST",
                data: this.ruleForm
            }).then((resp)=>{
                console.log(resp);
                
            })
        }
    },

}
</script>