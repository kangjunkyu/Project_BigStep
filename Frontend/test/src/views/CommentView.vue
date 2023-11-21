<template>
  <div style="background-color: beige; padding: 40px">
    <h4>Comment write</h4>
    <br />
    <CommentWrite />
    <CommentList />
  </div>
</template>

<script setup>
import CommentList from "../components/comment/CommentList.vue";
import CommentWrite from "../components/comment/CommentWrite.vue";
</script>

<style scoped></style>
