<template>
  <div>
    <h1>BigStep</h1>
    <HeaderNav/>
    <input type="text" v-model="word">
    <button @click="search" @keyup.enter="search">검색</button>
    <RouterView/>
  </div>
  
</template>

<script setup>
import {ref} from 'vue'
import router from '@/router'
import HeaderNav from './components/common/HeaderNav.vue';

const word = ref("")
const search = function(){
  router.push({name: "search"})
}

</script>

<style scoped>

</style>