<template>
  <div
    class="border min-w-[400px] bg-card text-card-foreground rounded-lg overflow-hidden shadow-lg max-w-sm hover:shadow-xl transition-all duration-200"
    data-v0-t="card"
  >
    <div class="p-4">
      <h2
        class="text-2xl font-bold hover:text-gray-700 transition-all duration-200"
      >
        {{ follower.name }}
      </h2>
      <h3 class="text-gray-500 hover:text-gray-600 transition-all duration-200">
        {{ follower.nickname }}
      </h3>
      <p
        class="mt-2 text-gray-600 hover:text-gray-700 transition-all duration-200"
      >
        {{ follower.id }}
      </p>
      <div class="flex mt-4 space-x-2">
        <button
          @click="insertFollow"
          class="inline-flex items-center justify-center text-sm font-medium ring-offset-background focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 border border-input bg-background hover:bg-accent h-9 rounded-md px-3 w-full hover:border-gray-700 hover:text-gray-700 transition-all duration-200"
        >
          Follow
        </button>
        <button
          @click="deleteFollow"
          class="inline-flex items-center justify-center text-sm font-medium ring-offset-background focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 border border-input bg-background hover:bg-accent h-9 rounded-md px-3 w-full hover:border-gray-700 hover:text-gray-700 transition-all duration-200"
        >
          Unfollow
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useFollowStore } from "@/stores/follow";

const FollowStore = useFollowStore();

const props = defineProps({
  follower: Object,
});
const insertFollow = function () {
  FollowStore.insertFollow(props.follower.id);
};

const deleteFollow = function () {
  FollowStore.deleteFollow(props.follower.id);
};
</script>

<style scoped></style>
