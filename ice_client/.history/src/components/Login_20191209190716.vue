<template>
  <div class="login-container" :style="login_container">
    <div class="login-box">
      <!-- 头像区域 -->
      <div class="avator-box">
        <img src="../assets/logo.png" alt />
      </div>
      <!-- 登录表单区域 -->
      <el-form
        ref="loginFormRef"
        :model="loginForm"
        :rules="loginFormRules"
        label-width="0px"
        class="login-form"
      >
        <!-- 用户名 -->
        <el-form-item prop="username">
          <el-input v-model="loginForm.publisherName" prefix-icon="el-icon-user"></el-input>
        </el-form-item>
        <!-- 密码 -->
        <el-form-item prop="password">
          <el-input v-model="loginForm.pwd" prefix-icon="el-icon-lock" type="password"></el-input>
        </el-form-item>
        <!-- 按钮区域 -->
        <el-form-item class="btns">
          <el-button type="warning" plain @click="showRegisterDialog()">注册</el-button>
          <el-button type="primary" plain @click="userLogin()">用户登录</el-button>
          <el-button type="success" plain @click="publisherLogin()">商家登录</el-button>
        </el-form-item>
      </el-form>
    </div>
    <!-- 注册的对话框 -->
    <el-dialog
      title="Register"
      :visible.sync="registerDialogVisible"
      width="50%"
      @close="registerDialogClosed"
    >
      <!-- 内容主体区域 -->
      <el-form
        :model="registerForm"
        :rules="registerFormRules"
        ref="registerFormRef"
        label-width="100px"
      >
        <!-- <el-form-item label="Game ID">
          <el-input v-model="editForm.gameid" disabled></el-input>
        </el-form-item>
        <el-form-item label="Title" prop="title">
          <el-input v-model="editForm.title"></el-input>
        </el-form-item>
        <el-form-item label="Price" prop="price">
          <el-input v-model="editForm.price"></el-input>
        </el-form-item>
        <el-form-item label="Discount">
          <el-radio-group v-model="editForm.discount" size="small">
            <el-radio-button label="On"></el-radio-button>
            <el-radio-button label="Off"></el-radio-button>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="Pre Order">
          <el-radio-group v-model="editForm.pre_order" size="small">
            <el-radio-button label="On"></el-radio-button>
            <el-radio-button label="Off"></el-radio-button>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="Consoles">
          <el-checkbox-group v-model="editForm.consoles" size="small">
            <el-checkbox-button v-for="con in consoleOptions" :label="con" :key="con">{{con}}</el-checkbox-button>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="Discription" prop="discription">
          <el-input v-model="editForm.discription"></el-input>
        </el-form-item>-->
      </el-form>
      <!-- 对话框底部确定取消按钮 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="cancelRegister">Cancel</el-button>
        <el-button type="primary" @click="register">Confirm</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { mixin } from '../mixins'
// import qs from 'qs'
export default {
  mixins: [mixin],
  data () {
    return {
      //
      login_container: {
        backgroundImage: 'url(' + require('../assets/wallhaven-457511.jpg') + ')'
      },
      // 这是登录表单的数据绑定对象
      loginForm: {
        publisherName: 'Naughty Dog',
        pwd: ''
      },
      // 这是登录表单的验证规则对象
      loginFormRules: {
        // 验证用户名是否合法
        publisherName: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
        ],
        // 验证密码是否合法
        pwd: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, max: 15, message: '长度在 6 到 15 个字符', trigger: 'blur' }
        ]
      },
      // 控制注册对话框的显示与隐藏
      registerDialogVisible: false,
      // 注册表单
      registerForm: {
        gameid: '12345',
        title: 'SUPERMARIO',
        price: '19.90',
        discount: 'On'
      },
      // 注册表单的验证规则对象
      registerFormRules: {
        // title: [
        //   { required: true, message: 'Please enter game name', trigger: 'blur' }
        // ],
        // price: [
        //   { required: true, message: 'Please enter game price', trigger: 'blur' },
        //   { validator: checkPrice, trigger: 'blur' }
        // ],
        // discription: [
        //   { validator: checkDiscription, trigger: 'blur' }
        // ]
      }
    }
  },
  methods: {
    publisherLogin () {
      console.log('publisherLogin')
      this.$refs.loginFormRef.validate(valid => {
        if (!valid) return this.$message.error('登录失败')
        this.$axios.post('/api/publisherLogin', this.loginForm)
          .then(response => {
            console.log('publisherLogin response', response)
            switch (response.data.status) {
              case '200':
                this.$message.success('登录成功')
                this.$router.push('/home')
                break
              case '404':
                this.$message.error('用户不存在')
                break
              default:
                this.$message.error('密码错误')
                break
            }
          })
          .catch(response => {
            this.$message.error('登陆失败')
          })
      })
    },
    userLogin () {
      console.log('userLogin')
      this.$refs.loginFormRef.validate(valid => {
        if (!valid) return this.$message.error('登录失败')
        let userInfo = {
          userName: this.loginForm.publisherName,
          pwd: this.loginForm.pwd
        }
        this.$axios.post('/api/login', userInfo)
          .then(response => {
            console.log('userLogin response', response)
            switch (response.data.status) {
              case '200':
                this.$message.success('登录成功')
                this.$router.push('/main')
                break
              case '404':
                this.$message.error('用户不存在')
                break
              default:
                this.$message.error('密码错误')
                break
            }
          })
          .catch(response => {
            this.$message.error('登陆失败')
          })
      })
    },
    // 展示注册的对话框
    showRegisterDialog () {
      this.registerDialogVisible = true
    },
    // 监听修改游戏对话框的关闭事件
    registerDialogClosed () {
      // this.$refs.registerFormRef.resetFields()
    },
    // 取消对游戏信息的修改
    cancelRegister () {
      // 关闭对话框
      this.registerDialogVisible = false
      // 提示取消修改
      this.$message('Cancel register')
    },
    // 修改游戏信息并提交
    register () {
      // 关闭对话框
      this.registerDialogVisible = false
      // 提示修改成功
      this.$message.success('Register success')
    }
  }
}
</script>

<style lang="less" scoped>
.login-container {
  background-color: #bd2c00;
  height: 100%;
}

.login-box {
  width: 450px;
  height: 300px;
  background-color: #fff;
  border-radius: 3px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  opacity: 0.75;

  .avator-box {
    height: 130px;
    width: 130px;
    border: 1px solid #eee;
    border-radius: 50%;
    padding: 10px;
    box-shadow: 0 0 10px #ddd;
    position: absolute;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #fff;
    img {
      width: 100%;
      height: 100%;
      border-radius: 50%;
      background-color: #eee;
    }
  }

  .login-form {
    position: absolute;
    bottom: 0;
    width: 100%;
    padding: 0 20px;
    box-sizing: border-box;
  }

  .btns {
    display: flex;
    justify-content: flex-end;
  }
}
</style>
