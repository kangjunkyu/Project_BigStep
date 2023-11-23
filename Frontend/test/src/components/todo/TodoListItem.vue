<template>
  <div class="test">
    <div
      :class="
        todo.complete
          ? 'w-full p-4 text-green-700 border border-green-300 rounded-lg bg-green-50 dark:bg-gray-800 dark:border-green-800 dark:text-green-400'
          : 'w-full p-4 text-blue-700 bg-blue-100 border border-blue-300 rounded-lg dark:bg-gray-800 dark:border-blue-800 dark:text-blue-400'
      "
    >
      <p>
        {{ todo.workout }} / {{ todo.startHour }}:{{ todo.startMinute }} ~
        {{ todo.endHour }}:{{ todo.endMinute }}
      </p>

      <div>
        <button
          @click="changeComplete"
          class="text-blue-700 hover:text-white border border-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2 dark:border-blue-500 dark:text-blue-500 dark:hover:text-white dark:hover:bg-blue-500 dark:focus:ring-blue-800"
        >
          완료
        </button>
        <button
          @click="showUpdate"
          class="text-green-700 hover:text-white border border-green-700 hover:bg-green-800 focus:ring-4 focus:outline-none focus:ring-green-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2 dark:border-green-500 dark:text-green-500 dark:hover:text-white dark:hover:bg-green-600 dark:focus:ring-green-800"
        >
          수정
        </button>
        <button
          @click="deleteTodo"
          class="text-red-700 hover:text-white border border-red-700 hover:bg-red-800 focus:ring-4 focus:outline-none focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2 dark:border-red-500 dark:text-red-500 dark:hover:text-white dark:hover:bg-red-600 dark:focus:ring-red-900"
        >
          삭제
        </button>
      </div>
    </div>
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
  const updateTodo = {
    ...props.todo,
    complete: !props.todo.complete,
  };

  // console.log(updatedTodo);

  diaryStore.updateTodo(updateTodo);
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

const showCreate = function () {
  router.push({ name: "todocreate" });
};
</script>

<style scoped>
.test {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  text-align: center;
  width: 460px;
  margin-bottom: 20px;
}
/* .complete {
  text-decoration: line-through;
} */
</style>
