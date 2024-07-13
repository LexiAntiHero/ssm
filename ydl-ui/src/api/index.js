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

 // Create axios instance
 const request = axios.create({
     // Axios request configuration includes the baseURL option, indicating the common part of the request URL
     baseURL: 'http://localhost:8080/',
     // Timeout
     timeout: 10000,
     // Set Content-Type, specifying JSON for frontend-backend interaction
     headers: {'Content-Type': 'application/json;charset=utf-8'}
 })
 export default request
 