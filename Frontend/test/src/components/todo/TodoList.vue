<template>
  <div class="marge">
    <div style="font-size: 30px">Todo List</div>
    <button
      @click="showCreate"
      class="text-white bg-blue-700 hover:bg-blue-800 focus:outline-none focus:ring-4 focus:ring-blue-300 font-medium rounded-full text-sm px-5 py-2.5 text-center me-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
    >
      추가
    </button>
  </div>
  <TodoListItem v-for="todo in todoList" :key="todo.todoId" :todo="todo" />
</template>

<script setup>
import { onMounted, computed, watch } from "vue";
import { useDiaryStore } from "@/stores/diary";
import router from "@/router";
import TodoListItem from "@/components/todo/TodoListItem.vue";

const diaryStore = useDiaryStore();

const todoList = computed(() => diaryStore.todoList);

onMounted(() => {
  diaryStore.getTodoList(diaryStore.selectedDiary.diaryId);
});

const showCreate = function () {
  router.push({ name: "todocreate" });
};
</script>

<style scoped>
.marge {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  width: 460px;
  padding-bottom: 23px;
}
</style>
