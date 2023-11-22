<template>
  <div class="flex">
    <aside class="w-64 bg-gray-800 text-white p-6" style="min-height: 100vh">
      <h1 class="text-2xl mb-4" style="display: flex">
        <img
          src="@/assets/곰발바닥2.png"
          style="height: 35px; padding-right: 10px"
        />BigStep
      </h1>
      <nav>
        <RouterLink
          class="block py-4 px-4 rounded transition duration-200 hover:bg-gray-700"
          to="/my-page"
        >
          MY PAGE
        </RouterLink>
        <a
          class="block py-6 px-4 rounded transition duration-200 hover:bg-gray-700"
          @click="logout"
        >
          Logout
        </a>
        <hr />
        <RouterLink
          class="block py-6 px-4 rounded transition duration-200 hover:bg-gray-700"
          to="/diary/list"
        >
          Diary
        </RouterLink>
        <RouterLink
          class="block py-4 px-4 rounded transition duration-200 hover:bg-gray-700"
          to="/follow"
        >
          Follow
        </RouterLink>
        <RouterLink
          class="block py-4 px-4 rounded transition duration-200 hover:bg-gray-700"
          to="/Event"
        >
          EVENT
        </RouterLink>
      </nav>
      <input
        v-model="word"
        @keyup.enter="search"
        type="text"
        id="search-navbar"
        class="block w-full p-2 ps-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
        placeholder="Search..."
      />
    </aside>
    <main class="flex grow bg-gray-100 p-6" style="min-height: 100vh">
      <RouterView />
    </main>
  </div>
</template>

<script setup>
import { useUserStore } from "@/stores/user";
import { ref } from "vue";

const logout = function () {
  userStore.logout();
};
const userStore = useUserStore();

const word = ref("");
const search = function () {
  userStore.search(word.value);
  word.value = "";
};
</script>

<style scoped></style>
