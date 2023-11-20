<template>
  <div>
    <h3>followingList</h3>
    <ul>
      <followingListItem
        v-for="(following, index) in followStore.FollowingList"
        :key="index"
        :following="following"
      />
    </ul>
  </div>
</template>

<script setup>
import { ref, onMounted, computed } from "vue";
import { useFollowStore } from "@/stores/follow";
import { useUserStore } from "@/stores/user";
import followingListItem from "@/components/follow/followingListItem.vue";
import router from "@/router";

const followStore = useFollowStore();

const userStore = useUserStore();

onMounted(() => {
  followStore.getFollowingList(userStore.loginUser.id);
});
</script>

<style scoped></style>
