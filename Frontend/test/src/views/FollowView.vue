<template>
  <div>
    <h3>FollowView</h3>

    <FollowingDiaryList />
    <RouterView />
  </div>
</template>

<script setup>
import FollowingDiaryList from "../components/follow/followingDiaryList.vue";
</script>

<style scoped></style>
