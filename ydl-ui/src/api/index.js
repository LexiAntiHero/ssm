/**
 * Basic API of axios
 * // Send POST request
 * axios({
 *  method: 'post',
 *  url: '/user/12345',
 *  data: {
 *    firstName: 'Fred',
 *    lastName: 'Flintstone'
 *  }
 *});
 * 
 */

 import axios from 'axios'
 import store from '@/store'

 // Create axios instance
 const request = axios.create({
     // Axios request configuration includes the baseURL option, indicating the common part of the request URL
     baseURL: 'http://localhost:8080/admin/',
     // Timeout
     timeout: 10000,
     // Set Content-Type, specifying JSON for frontend-backend interaction
     headers: {'Content-Type': 'application/json;charset=utf-8'}
 })

// Add a request interceptor
request.interceptors.request.use(function (config) {
    // Do something before the request is sent
    if (store.state.user.token) {
      // 'Bearer '
      config.headers['Authorization'] = store.state.user.token // Attach a custom token to every request; modify as needed based on your situation
      config.headers['username'] = store.state.user.username
    }
    return config;
  }, function (error) {
    // Do something with request error
    return Promise.reject(error);
  });
  
 
 export default request
 