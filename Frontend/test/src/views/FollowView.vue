<template>
  <div>
    <h3>FollowView</h3>
    <router-link to="/follow/follower">follower</router-link> |
    <router-link to="/follow/following">following</router-link>
    <FollowingDiaryList />
    <RouterView />
  </div>
</template>

<script setup>
import FollowingDiaryList from "../components/follow/followingDiaryList.vue";
</script>

<style scoped></style>
