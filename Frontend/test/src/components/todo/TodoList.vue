<template>
  <div class="marge">
    <div class="font-bold" style="font-size: 30px">Todos</div>
    <button
      @click="showCreate"
      class="text-gray-900 bg-white border border-gray-300 focus:outline-none hover:bg-gray-100 focus:ring-4 focus:ring-gray-200 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-gray-600 dark:text-white dark:border-gray-600 dark:hover:bg-gray-700 dark:hover:border-gray-600 dark:focus:ring-gray-700"
    >
      Write
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
