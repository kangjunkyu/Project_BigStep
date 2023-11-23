<template>
  <div>
    <p class="text-4xl font-bold" @click="showMyPage">My Page</p>
    <RouterView />
  </div>
</template>

<script setup>
import router from '@/router'

const showMyPage = function(){
  router.push("/my-page")
}
</script>

<style scoped></style>
