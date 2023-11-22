<template>
    <div class="flex flex-row">
        <div class= "basis-1/8 p-2 border-2 border-pink-400 rounded-lg" @click="showFollower">Follower : {{ followerList.length }}</div>
        <div class= "basis-1/8 p-2 mx-2.5 border-2 border-indigo-400 rounded-lg" @click="showFollowing">Following : {{ followingList.length }}</div>
    </div>
</template>

<script setup>
    import { useFollowStore } from "@/stores/follow";
    import { ref, onMounted, computed } from "vue";
    import { useUserStore } from "@/stores/user";
    import router from "@/router";

const followStore = useFollowStore();

const userStore = useUserStore();

const followerList = computed(() => followStore.FollowerList)
const followingList = computed(() => followStore.FollowingList)
onMounted(() => {
  followStore.getFollowerList(userStore.loginUser.id);
  followStore.getFollowingList(userStore.loginUser.id);
});


const showFollower = function(){
    router.push("/my-page/follower")
}

const showFollowing = function(){
    router.push("/my-page/following")
}

</script>

<style scoped>
    
</style>