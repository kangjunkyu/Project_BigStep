<template>
  <div class="bg-gray-400 p-10 rounded-lg">
    <br />
    <p class="text-2xl font-semibold">Diary Update</p>
    <label
      for="title"
      class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
      >제목</label
    >
    <input
      type="text"
      id="title"
      class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
      v-model="diary.title"
    /><br />
    <label
      for="content"
      class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
      >내용</label
    >
    <textarea
      type="text"
      id="content"
      class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
      v-model="diary.content"
    ></textarea
    ><br />
    <label
      for="date"
      class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
      >날짜</label
    >
    <input
      id="date"
      class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
      type="text"
      v-model="diary.date"
      readonly
    /><br />
    <button
      @click="updateDiary"
      class="cursor-pointer hover:text-blue-700 hover:font-bold hover:text-lg pt-2"
    >
      Complete
    </button>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";
import { useUserStore } from "@/stores/user";
import { useDiaryStore } from "@/stores/diary";

const route = useRoute();
const diaryId = route.params.diaryId;

const userStore = useUserStore();
const diaryStore = useDiaryStore();

onMounted(() => {
  diaryStore.getDiary(diaryId);
});

const diary = ref({
  title: diaryStore.selectedDiary.title,
  content: diaryStore.selectedDiary.content,
  date: diaryStore.selectedDiary.date,
  userId: userStore.loginUser.id,
  diaryId: diaryStore.selectedDiary.diaryId,
});

const updateDiary = function () {
  diaryStore.updateDiary(diary.value);
};
</script>

<style scoped></style>
