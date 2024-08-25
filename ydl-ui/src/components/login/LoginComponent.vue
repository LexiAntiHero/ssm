
<template>
  <el-container>
    <el-aside width="790px"
      ><el-image
        fit="contain"
        :src="require('@/assets/image/login_left.png')"
      ></el-image
    ></el-aside>
    <el-main>
      <el-card class="box-card login-card">
        <span class="login-title">SSM Login</span>
        <span class="login-tip">Welcome!</span>
        <el-form
          ref="user"
          :model="user"
          label-width="80px"
          :rules="rules"
        >
          <el-form-item label="username" prop="userName">
            <el-input
              v-model="user.userName"
              placeholder="Input username"
            ></el-input>
          </el-form-item>
          <el-form-item label="password" prop="password">
            <el-input
              v-model="user.password"
              type="password"
              placeholder="Input password"
              show-password
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="doLogin">Login</el-button>
          </el-form-item>
        </el-form>
      </el-card>
    </el-main>
  </el-container>
</template>

<script>
import { ElMessage } from 'element-plus';
//import { getInfo, getById } from '@/api/user';
export default {
  name: "LoginComponent",
  data() {
    return {
      // user information
      user: {
        userName: "SSM_admin",
        password: "xxxxxx",
      },
      rules: {
          userName:[
            {
              required: true,
              message: "Username should not be empty!",
              trigger: "blur",
            },
            {
              min: 5,
              max: 15,
              message: "Length should be 5 to 15",
              trigger: "blur",
            },
          ],
          password:[
            {
              required: true,
              message: "Password should not be empty!",
              trigger: "blur",
            },
          ],
        }
    };
  },
  methods: {
    doLogin(){
      this.$refs.user.validate(valid => {
          if(valid) {
            this.$store.dispatch("LOGIN", this.user).then((res) => {
              if(res.status === 200){
                // getInfo();
                // setTimeout(() => {
                //   getById(1);
                // }, 2000);

                
                this.$store.dispatch("GET_INFO").then(() => {
                  this.$router.push({name:"MainComponent"});
                });

              }
              
            });
          } else {
            ElMessage('Your username or password is not valid!')
          }
        })
    }
  }
};
</script>

<style scope>
.el-image {
  height: 885px;
  width: 750px;
}
.el-main {
  position: relative;
}
.login-card {
  position: absolute;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
  margin: auto;
  width: 480px;
  height: 400px;
  padding: 50px;
}
.login-title {
  width: 459px;
  height: 70px;
  font-size: 40px;
  font-family: AlibabaPuHuiTiB;
  color: #333333;
  line-height: 90px;
  letter-spacing: 1px;
  font-weight: 800;
  display: block;
  text-align: left;
}
.login-tip {
  width: 319px;
  height: 70px;
  font-size: 30px;
  font-family: PingFangSC-Regular, PingFang SC;
  font-weight: 400;
  color: #999999;
  line-height: 90px;
  letter-spacing: 1px;
  display: block;
  text-align: left;
  margin-bottom: 30px;
}
</style>

