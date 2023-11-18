import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_USER_URL = "http://localhost:7777/user"

export const useUserStore = defineStore('user', () => {
  const loginUser = ref({})
  const login = function(user){
    axios.post(REST_USER_URL+"/login", user)
    .then((response) => {
      loginUser.value = response.data
      router.push({name: "home"})
    })
    .catch(()=>{
      alert("로그인 실패")
    })
  }

  const logout = function(){
    axios.post(REST_USER_URL+"/logout")
    .then(()=>{
      loginUser.value = {}
      router.push({name: "home"})
    })
  }

  return {loginUser, login, logout}
},{persist: true})
