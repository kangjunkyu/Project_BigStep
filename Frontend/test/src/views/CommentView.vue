<template>
  <div style="background-color: beige; padding: 40px">
    <p class="font-bold text-lg">Comment</p>
    <CommentWrite />
    <CommentList />
  </div>
</template>

<script setup>
import CommentList from "../components/comment/CommentList.vue";
import CommentWrite from "../components/comment/CommentWrite.vue";
</script>

<style scoped></style>
