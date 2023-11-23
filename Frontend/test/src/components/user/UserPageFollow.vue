<template>
  <div class="flex flex-row items-center border-2 bg-white p-3 rounded-lg">

    <img src="@/assets/user-profile-black.png" style="width: 35px" alt="" />

    <div class="pr-7 pl-3 font-semibold text-lg mr-24">{{ userStore.loginUser.name }}</div>

    <span class="px-2 py-1 bg-red-200 text-red-800 rounded-md mr-4 font-semibold" @click="showFollower">
      <span>Follower : </span>
      <span>{{ followerList.length }}</span>
    </span>

    <span class="px-2 py-1 bg-blue-200 text-blue-800 rounded-md font-semibold" @click="showFollowing">
      <span>Following : </span>
      <span>{{ followingList.length }}</span>
    </span>
  </div>
  <br />
</template>
  
<script setup>
import { useFollowStore } from "@/stores/follow";
import { ref, onMounted, computed } from "vue";
import { useUserStore } from "@/stores/user";
import router from "@/router";

const followStore = useFollowStore();

const userStore = useUserStore();

const followerList = computed(() => followStore.FollowerList);
const followingList = computed(() => followStore.FollowingList);
onMounted(() => {
  followStore.getFollowerList(userStore.loginUser.id);
  followStore.getFollowingList(userStore.loginUser.id);
});

const showFollower = function () {
  router.push("/my-page/follower");
};

const showFollowing = function () {
  router.push("/my-page/following");
};
</script>
  
<style scoped></style>