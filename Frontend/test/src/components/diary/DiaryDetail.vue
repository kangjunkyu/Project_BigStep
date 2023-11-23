<template>
  <div>
    <div id="twoinone">
      <div id="card_diary">
        <div class="check">
          <div class="font-bold" style="font-size: 30px">Diary Detail</div>
          <div v-show="selectedDiary.userId === userStore.loginUser.id">
            <button
              @click="showUpdate"
              class="text-gray-900 bg-white border border-gray-300 focus:outline-none hover:bg-gray-100 focus:ring-4 focus:ring-gray-200 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-gray-600 dark:text-white dark:border-gray-600 dark:hover:bg-gray-700 dark:hover:border-gray-600 dark:focus:ring-gray-700"
            >
              Modify
            </button>
            <button
              @click="deleteDiary"
              class="text-gray-900 bg-white border border-gray-300 focus:outline-none hover:bg-gray-100 focus:ring-4 focus:ring-gray-200 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-gray-600 dark:text-white dark:border-gray-600 dark:hover:bg-gray-700 dark:hover:border-gray-600 dark:focus:ring-gray-700"
            >
              Delete
            </button>
          </div>
        </div>
        <div style="display: flex; justify-content: center; padding-top: 20px">
          <img
            style="height: 300px; width: 300px"
            v-show="diaryStore.selectedDiary.img"
            :src="`http://localhost:7777/upload/${diaryStore.selectedDiary.img}`"
          />
        </div>
        <div>
          <p
            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
          >
            {{ diaryStore.selectedDiary.title }}
            <div>
            {{ diaryStore.selectedDiary.userId }} /{{
              diaryStore.selectedDiary.date.substring(0, 10)
            }}
            </div>
          </p>
          <!-- <p
            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
          >
            {{ diaryStore.selectedDiary.userId }}
          </p>
          <p
            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
          >
            {{ diaryStore.selectedDiary.date }}
          </p> -->
          <p
            style="height: 200px"
            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
          >
            {{ diaryStore.selectedDiary.content }}
          </p>
        </div>
      </div>
      <div id="card_todo" v-show="selectedDiary.userId === userStore.loginUser.id">
        <TodoView />
      </div>
    </div>
    <CommentView />
  </div>
</template>

<script setup>
import { onMounted, computed, onBeforeMount, watch } from "vue";
import { useRoute } from "vue-router";
import { useDiaryStore } from "@/stores/diary";
import { useUserStore } from "@/stores/user";
import { useCommentStore } from "@/stores/comment";
import router from "@/router";
import CommentView from "@/views/CommentView.vue";
import TodoView from "@/views/TodoView.vue";

const route = useRoute();
const diaryId = route.params.diaryId;

const userStore = useUserStore();
const diaryStore = useDiaryStore();
const commentStore = useCommentStore();


const selectedDiary = computed(() => diaryStore.selectedDiary);
onBeforeMount(() => {
  diaryStore.getDiary(diaryId);
});

watch(selectedDiary, () => {
  diaryStore.getTodoList(diaryStore.selectedDiary.diaryId);
  commentStore.getCommentList();
});

// const todoList = computed(() => diaryStore.todoList);
// watch(todoList, () => {
//   diaryStore.getTodoList(diaryStore.selectedDiary.diaryId);
// });

const showUpdate = function () {
  router.push("/diary/update/" + diaryStore.selectedDiary.diaryId);
};

const deleteDiary = function () {
  diaryStore.deleteDiary(diaryStore.selectedDiary.diaryId);
};
</script>

<style scoped>
.hidden {
  display: none;
}

p {
  padding: 30px;
  margin: 20px;
  display: flex;
  justify-content: space-between;
}

#twoinone {
  display: flex;
  justify-content: center;
  /* margin: 10px; */
  flex-wrap: wrap;
}
#card_diary {
  display: flex;
  flex-direction: column;
  width: 450px;
}
#card_todo {
  /* width: 100%; */
  margin-left: 30px;
}

.check {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
</style>
