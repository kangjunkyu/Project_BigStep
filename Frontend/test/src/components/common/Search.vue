<template>
    <div>
        <input
        v-model="word"
        @keyup.enter="search"
        type="text"
        id="search-navbar"
        class="block w-full p-2 ps-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
        placeholder="Search..."
      />
    </div>
</template>

<script setup>
import { useUserStore } from "@/stores/user";
import { ref } from "vue";

const userStore = useUserStore();

const word = ref("");
const search = function () {
  userStore.search(word.value);
  word.value = "";
};
</script>

<style scoped>

</style>