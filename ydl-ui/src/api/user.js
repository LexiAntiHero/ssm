import request from "@/api";

// List users
// Query user list
export function listUser(query) {
    return request({
        url: '/user',
        method: 'get',
        params: query
    })
}

// Add a new user
export function addUser(data) {
    return request({
        url: '/user',
        method: 'post',
        data: data
    })
}
