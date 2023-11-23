<template>
  <div>
    <ul>
      <CommentListItem
        v-for="comment in commentList"
        :key="comment.commentId"
        :comment="comment"
      />
    </ul>
  </div>
</template>

<script setup>
import { ref, onMounted, computed } from "vue";
import { useCommentStore } from "@/stores/comment";
import CommentListItem from "@/components/comment/CommentListItem.vue";

const commentStore = useCommentStore();

const commentList = computed(() => commentStore.commentList);
onMounted(() => {
  commentStore.getCommentList();
});
</script>

<style scoped></style>
