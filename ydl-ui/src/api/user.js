import request from "@/api";

export function login(data) {
    return request({
        url: '/login',
        method: 'post',
        data: data
    })
}
export function logout() {
    return request({
        url: '/logout',
        method: 'get',
    })
}
export function listUser(data) {
    return request({
        url: '/ssmUser',
        method: 'get',
        params: data
    })
}

export function add(data) {
    return request({
        url: '/ssmUser',
        method: 'post',
        data: data
    })
}

export function getInfo() {
    return request({
        url: '/ssmUser/getInfo',
        method: 'get',
    })
}

export function getById(id) {
    return request({
        url: '/ssmUser/'+ id,
        method: 'get',
    })
}

export function update(data) {
    return request({
        url: '/ssmUser',
        method: 'put',
        data: data
    })
}

export function deleteUser(userId) {
    return request({
        url: '/ssmUser/'+userId,
        method: 'delete',
    })
}
// List users
// Query user list
// export function listUser(query) {
//     return request({
//         url: '/user',
//         method: 'get',
//         params: query
//     })
// }

// Add a new user
// export function addUser(data) {
//     return request({
//         url: '/user',
//         method: 'post',
//         data: data
//     })
// }
