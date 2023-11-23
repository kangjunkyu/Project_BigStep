<template>
  <div class="w-380">
    <div class="flex flex-row justify-between">
      <p class="text-xl font-bold">Update Todo</p>

      <button
        @click="updateTodo"
        class="text-gray-900 bg-white border border-gray-300 focus:outline-none hover:bg-gray-100 focus:ring-4 focus:ring-gray-200 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-gray-600 dark:text-white dark:border-gray-600 dark:hover:bg-gray-700 dark:hover:border-gray-600 dark:focus:ring-gray-700"
      >
        Modify
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
        v-model="selectedTodo.date"
      /><br />
      <br />
      <label>Workout : </label>
      <br />
      <input
        class="w-30 h-10 pr-4 pl-4"
        type="text"
        v-model="selectedTodo.workout"
        style="width: 300px"
      /><br />
      <br />
      <label>시작 시간 : </label>
      <br />
      <div class="flex">
        <div class="pr-5">
          <input
            type="number"
            v-model="selectedTodo.startHour"
            class="w-20 h-7 pr-4 pl-4"
          />시
        </div>
        <div>
          <input
            type="number"
            v-model="selectedTodo.startMinute"
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
            v-model="selectedTodo.endHour"
            class="w-20 h-7 pr-4 pl-4"
          />시
        </div>
        <div>
          <input
            type="number"
            v-model="selectedTodo.endMinute"
            class="w-20 h-7 pr-4 pl-4"
          />분
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, computed } from "vue";
import { useDiaryStore } from "@/stores/diary";
import { useUserStore } from "@/stores/user";
import { useRoute } from "vue-router";

const route = useRoute();
const diaryStore = useDiaryStore();
const userStore = useUserStore();

const todoId = route.params.todoId;

const selectedTodo = computed(() => diaryStore.selectedTodo);
const todo = ref({
  todoId: todoId,
  diaryId: diaryStore.selectedDiary.diaryId,
  userId: userStore.loginUser.id,
  date: selectedTodo.value.date,
  workout: selectedTodo.value.workout,
  startHour: selectedTodo.value.startHour,
  startMinute: selectedTodo.value.startMinute,
  endHour: selectedTodo.value.endHour,
  endMinute: selectedTodo.value.endMinute,
});

onMounted(() => {
  diaryStore.getTodo(todoId);
});

const updateTodo = function () {
  diaryStore.updateTodo(selectedTodo.value);
};
</script>

<style scoped></style>
