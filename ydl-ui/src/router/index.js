// Import two methods used to create routes and determine routing mode
import {
    createRouter,
    createWebHistory
} from 'vue-router'
import store from '@/store'
import storage from '@/util/storage'
/**
 * Define route information
 * 
 */
const routes = [{
    name: 'LoginComponent',
    path: '/login',
    component: () => import('@/components/login/LoginComponent.vue'),
    },
    {
    name: 'MainComponent',
    path: '/main',
    component: () => import('@/components/main/MainComponent.vue'),
    children: [
        {
            name: 'UserIndex',
            path: '/user',
            component: () => import('@/components/system/user/UserIndex.vue'),
        }
    ]
    }]

// Create a router instance and pass the `routes` configuration
// Here we use the html5 routing mode, URLs do not have a #
// Pay attention to this when deploying the project.
const router = createRouter({
    history: createWebHistory(),
    routes, 
})

// Global route guard
router.beforeEach((to) => {
    if(to.name === 'LoginComponent') {
        return true
    }
    if(!store.getters.isLogin) {
        if(!storage.getSessionObject("loginUser")) {
            router.push({name:'LoginComponent'})
        } else {
            store.dispatch("RECOVERY_USER")
            store.dispatch("GET_INFO")
        }
    }
    return true
})

// Export the router instance
export default router
