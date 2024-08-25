import store from '@/store'

export default {
    // v-hasPermissions="system:user:add,system:user:query"
    hasPermission: {
        mounted(el, binding) {
            const { value } = binding
            console.log(value)
            const all_permission = "*:*:*";
            const permissions = store.getters && store.getters.permissions
            if (value && value instanceof Array && value.length > 0) {
                const hasPermissions = permissions.some(permission => {
                    return all_permission === permission || value.includes(permission)
                })
                if (!hasPermissions) {
                    // Remove the current element
                    el.parentNode && el.parentNode.removeChild(el)
                }
            } else {
                throw new Error(`Please set the operation permission tag value`)
            }
        }
    },
    hasRole: {
        mounted(el, binding) {
            const { value } = binding
            
            // const all_permission = "admin";
            const permissions = store.getters && store.getters.roles
            if (value && value instanceof Array && value.length > 0) {
                console.log(value)
                console.log("p--"+permissions)
                const hasRoles = permissions.some(role => {
                    return value.includes(role)
                })
                if (!hasRoles) {
                    // Remove the current element
                    el.parentNode && el.parentNode.removeChild(el)
                }
            } else {
                throw new Error(`Please set the operation permission tag value`)
            }
        }
    }
}
