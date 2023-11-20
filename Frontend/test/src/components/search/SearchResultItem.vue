<template>
  <li>
    <span>{{ user.id }} / {{ user.name }} / {{ user.email }}</span>
    <button @click="insertFollow">Follow</button>
    <button @click="deleteFollow">Unfollow</button>
  </li>
</template>

<script setup>
import { useFollowStore } from "@/stores/follow";

const FollowStore = useFollowStore();

const props = defineProps({
  user: Object,
});

const insertFollow = function () {
  FollowStore.insertFollow(props.user.id);
};

const deleteFollow = function () {
  FollowStore.deleteFollow(props.user.id);
};
</script>

<style scoped></style>
