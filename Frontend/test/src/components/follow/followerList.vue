<template>
  <div>
    <p class="text-xl font-bold">Following List</p>
    <div class="flex justify-start flex-wrap gap-8">
      <followerListItem
        v-for="(follower, index) in followStore.FollowerList"
        :key="index"
        :follower="follower"
      />
    </div>
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
