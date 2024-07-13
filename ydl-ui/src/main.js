import { createApp } from 'vue'
import App from './App.vue'
import router from '@/router'
import store from '@/store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

let app = createApp(App);
//Global installation of router component.
app.use(router).use(store).use(ElementPlus).mount('#app')
