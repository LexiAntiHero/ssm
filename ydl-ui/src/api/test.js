import request from "@/api";

// List users
// Query user list
export function test(query) {
    return request({
        url: '/test',
        method: 'get',
        params: query
    })
}


