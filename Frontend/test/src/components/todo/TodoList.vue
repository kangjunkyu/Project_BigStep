<template>
  <div>
    <p>test</p>
    <button
      @click="showCreate"
      class="text-white bg-blue-700 hover:bg-blue-800 focus:outline-none focus:ring-4 focus:ring-blue-300 font-medium rounded-full text-sm px-5 py-2.5 text-center me-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
    >
      추가
    </button>
    <TodoListItem v-for="todo in todoList" :key="todo.todoId" :todo="todo" />
  </div>
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

<style scoped></style>
