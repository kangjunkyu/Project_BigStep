<template>
  <li>
    <div class="commentWrap">
      <span v-show="!isUpdate"
        >{{ props.comment.userId }} / {{ props.comment.content }}</span
      >
      <div>
        <span v-show="userStore.loginUser.id === comment.userId">
          <!-- <button
            @click="showUpdate"
            v-show="!isUpdate"
            class="text-white bg-green-700 hover:bg-green-800 focus:outline-none focus:ring-4 focus:ring-green-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2 dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800"
          >
            수정
          </button> -->
          <span
            @click="showUpdate"
            v-show="!isUpdate"
            class="cursor-pointer hover:text-green-700 hover:font-bold hover:text-lg mx-4"
            >수정</span
          >

          <!-- <button
            @click="deleteComment"
            v-show="!isUpdate"
            class="text-white bg-yellow-400 hover:bg-yellow-500 focus:outline-none focus:ring-4 focus:ring-yellow-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2 dark:focus:ring-yellow-900"
          >
            삭제
          </button> -->
          <span
            @click="deleteComment"
            v-show="!isUpdate"
            class="cursor-pointer hover:text-red-700 hover:font-bold hover:text-lg mx-2"
            >삭제</span
          >
        </span>
      </div>
    </div>
  </li>
  <div v-show="isUpdate">
    <textarea
      id="message"
      rows="4"
      class="mb-3 block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500"
      placeholder="Write your thoughts here..."
      v-model="comment.content"
      @keyup.enter="updateComment"
    ></textarea>
    <p class="ms-auto text-xs text-gray-500 dark:text-gray-400">
      수정 혹은 이전으로 돌아가시려면 Enter Key를 눌러주세요.
    </p>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useUserStore } from "@/stores/user";
import { useCommentStore } from "@/stores/comment";
const userStore = useUserStore();
const commentStore = useCommentStore();

const isUpdate = ref(false);

const props = defineProps({
  comment: Object,
});

const comment = ref({
  commentId: props.comment.commentId,
  diaryId: props.comment.diaryId,
  userId: props.comment.userId,
  nickname: props.comment.nickname,
  content: props.comment.content,
});

const deleteComment = function () {
  commentStore.deleteComment(props.comment.commentId);
};

const showUpdate = function () {
  isUpdate.value = !isUpdate.value;
};

const updateComment = function () {
  commentStore.updateComment(comment.value);
  isUpdate.value = !isUpdate.value;
};
</script>

<style scoped>
.commentWrap {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  text-align: center;
  padding-bottom: 6px;
}
</style>
