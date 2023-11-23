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
          Weather
        </RouterLink>
        <Search />
      </nav>
    </aside>
    <main class="flex-1 bg-gray-100 p-6" style="min-height: 100vh">
      <RouterView />
    </main>
  </div>
</template>

<script setup>
import { useUserStore } from "@/stores/user";
import { ref } from "vue";

import Search from "@/components/common/Search.vue";

const logout = function () {
  userStore.logout();
};
const userStore = useUserStore();
</script>

<style scoped></style>
