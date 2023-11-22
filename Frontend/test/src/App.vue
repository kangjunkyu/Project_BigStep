<template>
  <div>
    <RouterView />
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useUserStore } from "@/stores/user";
import HeaderNav from "./components/common/HeaderNav.vue";
import NavTest from "./views/AfterLoginView.vue";
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
