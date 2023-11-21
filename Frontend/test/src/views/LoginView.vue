<template>
    <div>
      <h3>LoginView</h3>
      <label>ID : </label>
      <input type="text" v-model="user.id"/><br>
      <label>PW : </label>
      <input type="password" v-model="user.pw"/><br>
      <button @click="login">Login</button>


      <hr>
      <LoginNaver/>
    </div>
  </template>
  
  <script setup>
  
    import {ref,} from 'vue'
    import { useUserStore } from '@/stores/user';
    import LoginNaver from '@/components/login/LoginNaver.vue';
  
    const userStore = useUserStore()

    const user = ref({
      id: "",
      pw: ""
    })

    const login = function(){
      userStore.login(user.value)
    }

    


  </script>
  
  <style scoped>
  
  </style>