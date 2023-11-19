import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_USER_URL = "http://localhost:7777/user/"

export const useUserStore = defineStore('user', () => {
  const loginUser = ref({})
  const login = function(user){
    axios.post(REST_USER_URL+"login", user)
    .then((response) => {
      loginUser.value = response.data
      router.push({name: "home"})
    })
    .catch(()=>{
      alert("로그인 실패")
    })
  }

  const logout = function(){
    axios.post(REST_USER_URL+"logout")
    .then(()=>{
      loginUser.value = {}
      router.push({name: "home"})
    })
  }

  const searchWord = ref("")
  const searchResult = ref([])
  const search = function(word) {
    axios.get(REST_USER_URL+`users/${word}`)
    .then((response) => {
        searchResult.value = response.data
        searchWord.value = word;
        console.log(searchResult.value)
        router.push("/search/result")
    })
    .catch(() => {

    })
    
  }

  const signupUser = function(user){
    axios.post(REST_USER_URL, user)
    .then(()=>{
      alert("회원가입 완료")
      router.push("/")
    })
    .catch(()=>{

    })
  }

  return {loginUser, login, logout, search, searchWord, searchResult, signupUser}
},{persist: true})
