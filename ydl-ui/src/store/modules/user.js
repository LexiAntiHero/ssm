import {login, logout, getInfo} from '@/api/user.js'
import storage from '@/util/storage.js'
const user = {
  state: {
    username:'',
    nickname:'',
    token:'',
    roles:[],
    permissions:[]
  },
  getters:{ 
    isLogin(state) {
      return state.username !== '' && state.token !== '';
    },
    permissions(state) {
      return state.permissions;
    },
    roles(state) {
      return state.roles;
    }
  },
  mutations: {
    SAVE_USERNAME(state, username){
      state.username = username;
    },
    SAVE_NICKNAME(state, nickname){
      state.nickname = nickname;
    },
    SAVE_TOKEN(state, token){
      state.token = token;
    },
    SAVE_ROLES(state, roles) {
      state.roles = roles;
    },
    SAVE_PERMISSIONS(state, permissions) {
      state.permissions = permissions;
    },
  },
  actions: {
    LOGIN({commit},user){
      return new Promise(function(resolve) {
          login(user).then(res => {
              commit("SAVE_USERNAME",res.data.ssmUser.userName);
              commit("SAVE_NICKNAME",res.data.ssmUser.nickName);
              commit("SAVE_TOKEN",res.data.token);
              storage.saveSessionObject("loginUser", res.data);
              resolve(res);
          })
      })  
    },
    LOGOUT({commit}){
      return new Promise(function(resolve) {
          logout().then(res => {
              commit("SAVE_USERNAME",'');
              commit("SAVE_NICKNAME",'');
              commit("SAVE_TOKEN",'');
              storage.remove("loginUser");
              resolve(res);
          })
      })  
    },
    RECOVERY_USER({commit}){
      let loginUser = storage.getSessionObject("loginUser");
      if(loginUser) {
           commit("SAVE_USERNAME",loginUser.ssmUser.userName);
           commit("SAVE_NICKNAME",loginUser.ssmUser.nickName);
           commit("SAVE_TOKEN",loginUser.token);
      }
   },
   GET_INFO({commit}){
    return new Promise((resolve) => {
        getInfo().then(res => {
            console.log(res);
            commit("SAVE_ROLES", res.data.roles);
            commit("SAVE_PERMISSIONS", res.data.perms)
            resolve();
        });
      }); 
    }
  }
}

export default user
