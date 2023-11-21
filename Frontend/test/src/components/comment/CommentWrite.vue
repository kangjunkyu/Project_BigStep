<template>
  <div>
    <textarea
      placeholder="댓글 작성"
      cols="40"
      v-model="content"
      @keyup.enter="writeComment"
    ></textarea>
    <br />
    <button
      @click="writeComment"
      class="text-white bg-blue-700 hover:bg-blue-800 focus:outline-none focus:ring-4 focus:ring-blue-300 font-medium rounded-full text-sm px-5 py-2.5 text-center me-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
    >
      작성
    </button>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useCommentStore } from "@/stores/comment";

const commentStore = useCommentStore();

const content = ref("");

const writeComment = function () {
  commentStore.writeComment(content.value);
  content.value = "";
};
</script>

<style scoped></style>
