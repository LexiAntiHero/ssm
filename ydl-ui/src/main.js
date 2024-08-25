import { createApp } from 'vue'
import App from './App.vue'
import router from '@/router'
import store from '@/store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import '@/assets/style/common.css'
import directive from '@/directive'


let app = createApp(App);
//Global installation of router component.app.use(router).use(store).use(ElementPlus)
app.use(router).use(store).use(ElementPlus)

for(let key in directive){
  console.log(key)
  app.directive(key,directive[key]);
}

app.mount('#app')