<template>
  <div>
    <span :class="{ complete: todo.complete }" @click="showDetail">
      {{ todo.workout }} / {{ todo.startHour }}:{{ todo.startMinute }} ~
      {{ todo.endHour }}:{{ todo.endMinute }}</span
    >
    <button
      @click="changeComplete"
      class="text-white bg-red-700 hover:bg-red-800 focus:outline-none focus:ring-4 focus:ring-red-300 font-medium rounded-full text-sm px-5 py-2.5 text-center me-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-800"
    >
      완료
    </button>
    <button
      @click="showUpdate"
      class="text-white bg-green-700 hover:bg-green-800 focus:outline-none focus:ring-4 focus:ring-green-300 font-medium rounded-full text-sm px-5 py-2.5 text-center me-2 mb-2 dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800"
    >
      수정
    </button>
    <button
      @click="deleteTodo"
      class="text-white bg-yellow-400 hover:bg-yellow-500 focus:outline-none focus:ring-4 focus:ring-yellow-300 font-medium rounded-full text-sm px-5 py-2.5 text-center me-2 mb-2 dark:focus:ring-yellow-900"
    >
      삭제
    </button>
  </div>
</template>

<script setup>
import router from "@/router";
import { useDiaryStore } from "@/stores/diary";

const diaryStore = useDiaryStore();
const props = defineProps({
  todo: Object,
});

const changeComplete = function () {
  const todo = {
    todoId: props.todo.todoId,
    diaryId: props.todo.diaryId,
    userId: props.todo.userId,
    date: props.todo.date,
    workout: props.todo.workout,
    startHour: props.todo.startHour,
    startMinute: props.todo.startMinute,
    endHour: props.todo.endHour,
    endMinute: props.todo.endMinute,
    complete: !props.todo.complete,
  };

  diaryStore.updateTodo(todo);
};

const showDetail = function () {
  router.push({ name: "tododetail", params: { todoId: props.todo.todoId } });
};

const showUpdate = function () {
  router.push({ name: "todoupdate", params: { todoId: props.todo.todoId } });
};

const deleteTodo = function () {
  diaryStore.deleteTodo(props.todo.todoId, props.todo.diaryId);
};
</script>

<style scoped>
.complete {
  text-decoration: line-through;
}
</style>
