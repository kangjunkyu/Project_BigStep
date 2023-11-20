<template>
  <div>
    <h3>followerList</h3>
    <ul>
      <followerListItem
        v-for="(follower, index) in followStore.FollowerList"
        :key="index"
        :follower="follower"
      />
    </ul>
  </div>
</template>

<script setup>
import { useFollowStore } from "../../stores/follow";
import { ref, onMounted, computed } from "vue";
import { useUserStore } from "@/stores/user";
import followerListItem from "@/components/follow/followerListItem.vue";
import router from "@/router";

const followStore = useFollowStore();

const userStore = useUserStore();

onMounted(() => {
  followStore.getFollowerList(userStore.loginUser.id);
});
</script>

<style scoped></style>
