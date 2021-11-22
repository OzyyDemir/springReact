import axios from "axios"


export const signup = (body) => {
  return  axios.post('/api/users/add', body)
}

export const login = creds =>{
  return axios.post('/api/auth', {}, {auth: creds})
}

export const getUsers = () => {
  return axios.get('api/users/getall')
}