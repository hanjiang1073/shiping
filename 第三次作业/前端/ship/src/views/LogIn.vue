<template>
  <div class="container">
    <el-tabs v-model="activeName" type="border-card" class="tabs">
      <el-tab-pane label="登录" name="login">
        <el-form ref="loginForm" :model="loginForm" label-width="80px" class="form" :rules="rules">
          <el-form-item label="用户ID" prop="id">
            <el-input v-model="loginForm.id"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="passwords">
            <el-input type="password" v-model="loginForm.passwords"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="handleLogin">登录</el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane>
      <el-tab-pane label="注册" name="register">
        <el-form ref="registerForm" :model="registerForm" label-width="80px" class="form" :rules="rules">
          <el-form-item label="用户ID" prop="id">
            <el-input v-model="registerForm.id"></el-input>
          </el-form-item>
          <el-form-item label="用户名" prop="name">
            <el-input v-model="registerForm.name"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="passwords">
            <el-input type="password" v-model="registerForm.passwords"></el-input>
          </el-form-item>
          <el-form-item label="确认密码" prop="confirmPasswords">
            <el-input type="password" v-model="registerForm.confirmPasswords"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="handleRegister">注册</el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      activeName: 'login',
      loginForm: {
        id: '',
        passwords: ''
      },
      registerForm: {
        id: '',
        name: '',
        passwords: '',
        confirmPasswords: ''
      },
      rules: {
        id: [{ required: true, message: '请输入用ID', trigger: 'blur' }],
        name: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
        passwords: [{ required: true, message: '请输入密码', trigger: 'blur' }],
        confirmPasswords: [
          { required: true, message: '请确认密码', trigger: 'blur' },
          {
            validator: (rule, value, callback) => {
              if (value !== this.registerForm.passwords) {
                console.log(this.registerForm.passwords)
                console.log(value)
                callback(new Error('两次输入的密码不一致'))
              } else {
                callback()
              }
            }
          }
        ]
      }
    }
  },
  methods: {
    handleLogin() {
      this.loginForm.id = parseInt(this.loginForm.id)
      console.log(this.loginForm)
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
          // 登录逻辑
          
          axios.post('http://localhost:9999/User/login', this.loginForm).then(response => {
            console.log(response.data)
            if(response.data.msg == "登录成功"){
              this.$store.dispatch('login', {id: this.loginForm.id , token: response.data.token });
              this.$message.success("登录成功")
              this.$router.push('/addOrder');
            }
            else{
              this.$message.error("用户ID或密码错误")
            }
          }).catch(error => {
            console.log(error)
          })
          
          console.log(1)
          return true
        } else {
          console.log(2)
          return false
        }
      })
    },
    handleRegister() {
      this.$refs.registerForm.validate((valid) => {
        if (valid) {
          // 注册逻辑
          axios.post('http://localhost:9999/User/register', this.registerForm).then(response => {
            console.log(response.data)
            if(response.data.msg == "注册成功"){
              this.$store.dispatch('login', {id: this.registerForm.id , token: response.data.token });
              this.$message.success("注册成功")
              this.$router.push('/addOrder');
            }
            else{
              this.$message.error("注册失败")
            }
          }).catch(error => {
            console.log(error)
          })
          return true;
        } else {
          return false
        }
      })
    }
  }
}
</script>

<style>
.container {
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}

.form {
  max-width: 400px;
  margin: 0 auto;
}

.tabs {
  width: 400px;
}
</style>
