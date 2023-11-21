<template>
  <div class="flex h-screen overflow-hidden">
    <aside class="w-64 bg-gray-800 text-white p-6">
      <h1 class="text-2xl mb-4" style="display: flex">
        <img
          src="../../assets/곰발바닥2.png"
          style="height: 35px; padding-right: 10px"
        />BigStep
      </h1>
      <nav>
        <RouterLink
          class="block py-2.5 px-4 rounded transition duration-200 hover:bg-gray-700"
          to="/follow"
        >
          Follow
        </RouterLink>
        <RouterLink
          class="block py-2.5 px-4 rounded transition duration-200 hover:bg-gray-700"
          to="/my-page"
        >
          MY PAGE
        </RouterLink>
        <RouterLink
          class="block py-2.5 px-4 rounded transition duration-200 hover:bg-gray-700"
          to="/diary/list"
        >
          DiaryList
        </RouterLink>
        <RouterLink
          class="block py-2.5 px-4 rounded transition duration-200 hover:bg-gray-700"
          to="/Event"
        >
          EVENT
        </RouterLink>
        <a
          class="block py-2.5 px-4 rounded transition duration-200 hover:bg-gray-700"
          href=""
          @click="logout"
        >
          Logout
        </a>
      </nav>
    </aside>
    <main class="flex-1 bg-gray-100 p-6">
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
};
</script>

<style scoped></style>
