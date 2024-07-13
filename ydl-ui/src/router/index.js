// Import two methods used to create routes and determine routing mode
import {
    createRouter,
    createWebHistory
} from 'vue-router'

/**
 * Define route information
 * 
 */
const routes = []

// Create a router instance and pass the `routes` configuration
// Here we use the html5 routing mode, URLs do not have a #
// Pay attention to this when deploying the project.
const router = createRouter({
    history: createWebHistory(),
    routes, 
})

// Global route guard
router.beforeEach((to, from) => {
    console.log(to)
    console.log(from)
    return true
})

// Export the router instance
export default router
