<template>
  <div class="w-380">
    <div class="flex flex-row justify-between">
      <p class="text-xl font-bold">Create Todo</p>

      <button
        @click="createTodo"
        class="text-gray-900 bg-white border border-gray-300 focus:outline-none hover:bg-gray-100 focus:ring-4 focus:ring-gray-200 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-gray-600 dark:text-white dark:border-gray-600 dark:hover:bg-gray-700 dark:hover:border-gray-600 dark:focus:ring-gray-700"
      >
        Create
      </button>
    </div>
    <div class="pt-5">
      <label>Date : </label>
      <br />
      <input
        class="h-10 pr-4 pl-4"
        style="width: 300px"
        type="text"
        readonly
        v-model="todo.date"
      /><br />
      <br />
      <label>Workout : </label>
      <br />
      <input
        class="w-30 h-10 pr-4 pl-4"
        type="text"
        v-model="todo.workout"
        style="width: 300px"
      /><br />
      <br />
      <label>시작 시간 : </label>
      <br />
      <div class="flex">
        <div class="pr-5">
          <input
            type="number"
            v-model="todo.startHour"
            class="w-20 h-7 pr-4 pl-4"
          />시
        </div>
        <div>
          <input
            type="number"
            v-model="todo.startMinute"
            class="w-20 h-7 pr-4 pl-4"
          />분<br />
        </div>
      </div>
      <br />
      <label>완료 시간 : </label>
      <br />
      <div class="flex">
        <div class="pr-5">
          <input
            type="number"
            v-model="todo.endHour"
            class="w-20 h-7 pr-4 pl-4"
          />시
        </div>
        <div>
          <input
            type="number"
            v-model="todo.endMinute"
            class="w-20 h-7 pr-4 pl-4"
          />분
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useDiaryStore } from "@/stores/diary";
import { useUserStore } from "@/stores/user";

const userStore = useUserStore();
const diaryStore = useDiaryStore();
const todo = ref({
  diaryId: diaryStore.selectedDiary.diaryId,
  userId: userStore.loginUser.id,
  date: diaryStore.selectedDiary.date,
  workout: "",
  startHour: 0,
  startMinute: 0,
  endHour: 0,
  endMinute: 0,
});

const createTodo = function () {
  diaryStore.createTodo(todo.value);
};
</script>

<style scoped></style>
