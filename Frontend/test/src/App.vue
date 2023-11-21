<template>
  <div v-if="userStore.loginUser == null">
    <HeaderNav />
    <!-- <TestTem /> -->
    <div class="mainbackground">
      <!-- <input type="text" v-model="word" @keyup.enter="search" />
        <button @click="search">검색</button> -->
      <RouterView />
    </div>
  </div>
  <div v-else>
    <NavTest />
    <!-- <HeaderNav /> -->
    <!-- <TestTem /> -->
    <div class="mainbackground">
      <!-- <input type="text" v-model="word" @keyup.enter="search" />
    <button @click="search">검색</button> -->
      <!-- <RouterView /> -->
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useUserStore } from "@/stores/user";
import HeaderNav from "./components/common/HeaderNav.vue";
import NavTest from "./components/common/NavTest.vue";
import TestTem from "./components/common/TestTem.vue";

const userStore = useUserStore();

const word = ref("");
const search = function () {
  userStore.search(word.value);
};
</script>

<style scoped>
.mainbackground {
  display: flex;
  flex-direction: column;
  /* align-items: center; */
  /* align-content: center; */
  /* justify-content: center; */
  /* justify-items: center; */
}
</style>
