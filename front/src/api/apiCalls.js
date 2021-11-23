import axios from "axios"



export const signup = (body) => {
  return  axios.post('/api/users/add', body)
}

export const login = creds =>{
  return axios.post('/api/auth', {}, {auth: creds})
}

export const getUsers = (page=0,size=3) => {
  return axios.get(`api/users/getall?page=${page}&size=${size}`)
}

export const setAuthorizationHeader = ({ username, password, isLoggedIn }) => {
  if(isLoggedIn){
    const authorizationHeaderValue = `Basic ${btoa(username + ":" + password)}`
    axios.defaults.headers['Authorization'] = authorizationHeaderValue
    } else {
      delete axios.defaults.headers['Authorization'] 
    }
}
