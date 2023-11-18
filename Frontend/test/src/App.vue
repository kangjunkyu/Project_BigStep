<template>
  <div>
    <h1>BigStep</h1>
    <HeaderNav/>
    <input type="text" v-model="word" @keyup.enter="search"> 
    <button @click="search">검색</button>
    <RouterView/>
  </div>
  
</template>

<script setup>
import {ref} from 'vue'
import {useUserStore} from '@/stores/user'
import HeaderNav from './components/common/HeaderNav.vue';

const userStore = useUserStore()

const word = ref("")
const search = function(){
  userStore.search(word.value);
}

</script>

<style scoped>

</style>