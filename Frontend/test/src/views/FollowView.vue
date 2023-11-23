<template>
  <div>
    <p class="text-4xl font-bold">Follow</p>

    <FollowingDiaryList />
    <RouterView />
  </div>
</template>

<script setup>
import FollowingDiaryList from "../components/follow/followingDiaryList.vue";
</script>

<style scoped></style>
