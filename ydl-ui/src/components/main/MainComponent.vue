
<template>
  <el-container>
 
      <el-aside width="200px">
        <el-row>
          <el-col :span="24">
            <el-image
              style="
                width: 120px;
                height: 60px;
                display: block;
                margin: 40px auto;
              "
              fit="fill"
              :src="require('@/assets/image/main_logo.png')"
            ></el-image>
            <el-menu
              active-text-color="#ffd04b"
              background-color="#191A22"
              class="el-menu-vertical-demo"
              default-active="2"
              text-color="#fff"
            >
              <el-sub-menu index="1">
                <template #title>
                  <el-icon></el-icon>
                  <span>System Management</span>
                </template>

                <el-menu-item index="1-1" @click="open('UserIndex')">
                  User Management</el-menu-item
                >
                <el-menu-item index="1-2" @click="open('role')">
                  Role Management</el-menu-item
                >
              </el-sub-menu>
              <el-menu-item index="2">
                <el-icon></el-icon>
                <span>Customer Management</span>
              </el-menu-item>
            </el-menu>
          </el-col>
        </el-row>
      </el-aside>
      <el-container>
        <el-header>Name: {{$store.state.user.nickname}}
        <el-button color="#626aef" @click="doLogout" plain>logout</el-button></el-header>
        <!--router forward-->
        <el-main>
          <router-view />
        </el-main>
      </el-container>
  </el-container>
</template>
<script setup>
import {useStore} from 'vuex'
  import { useRouter } from 'vue-router';

  let store = useStore()
  const router = useRouter()
  let doLogout = function(){
    store.dispatch("LOGOUT").then(res => {
      console.log(res);
      router.push({name:"LoginComponent"});
    });
  };

  let open = function(name) {
    router.push({name})
  }

</script>

<style scoped>
.el-container {
  height: 100%;
}

.el-header {
  margin-bottom: 20px;
  background: #e9eef3;
}

.el-footer {
  line-height: 60px;
}

.el-aside {
  background-color: #191a22;
  color: var(--el-text-color-primary);
  text-align: center;
  line-height: 200px;
}

.el-main {
  background-color: #fcfcfc;
  color: var(--el-text-color-primary);
  text-align: center;
}
</style>
