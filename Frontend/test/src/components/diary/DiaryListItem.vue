<template>
  <!-- <div class="diarycontainer">
    <div
      @click="showDetail"
      class="bg-white border-b dark:bg-gray-800 dark:border-gray-700"
    >
      <br />
      <li style="font-size: 30px" class="text-black dark:text-white">
        <p>{{ diary.title }}</p>
      </li>
      <li class="text-black dark:text-white">
        <p>{{ diary.userId }}</p>
      </li>
      <li class="text-black dark:text-white">
        <p>{{ diary.content }}</p>
      </li>
    </div>
  </div> -->
  <div class="min-w-[364px] w-full max-w-sm" style="width:30%;">
    <div class="w-full max-w-sm bg-white dark:bg-gray-800 rounded-xl shadow-md overflow-hidden mx-auto"
      @click="showDetail">
      <div class="flex justify-between items-center px-6 py-4">
        <div class="flex space-x-4">
          <!-- <div>
        <img
          alt="Profile"
          class="rounded-full"
          height="48"
          src="/placeholder.svg"
          width="48"
          style="aspect-ratio: 48 / 48; object-fit: cover;"
        />
      </div> -->
          <div>
            <div class="text-lg font-bold dark:text-white">{{ diary.title }}</div>
            <div class="text-sm text-gray-500 dark:text-gray-200">@{{ diary.userId }}</div>
          </div>
        </div>
        <div>
          <svg class=" h-4 w-4 text-gray-500 dark:text-gray-200" fill="none" height="24" stroke="currentColor"
            stroke-linecap="round" stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24" width="24"
            xmlns="http://www.w3.org/2000/svg">
            <circle cx="12" cy="12" r="1"></circle>
            <circle cx="19" cy="12" r="1"></circle>
            <circle cx="5" cy="12" r="1"></circle>
          </svg>
        </div>
      </div>
      <div class="px-6 py-4">
        <div class="text-sm text-gray-800 dark:text-gray-200 break-all">
          {{ diary.content }}
        </div>
      </div>
      <div class="flex justify-between items-center space-x-4 pt-4 border-t border-gray-200 dark:border-gray-700 p-4">
        <div class="flex items-center space-x-4">
          <!-- <svg
        class=" h-4 w-4 text-gray-500 dark:text-gray-200"
        fill="none"
        height="24"
        stroke="currentColor"
        stroke-linecap="round"
        stroke-linejoin="round"
        stroke-width="2"
        viewBox="0 0 24 24"
        width="24"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path d="M9 20H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2v1"></path>
        <path d="M12 10v4h4"></path>
        <path d="m12 14 1.5-1.5c.9-.9 2.2-1.5 3.5-1.5s2.6.6 3.5 1.5c.4.4.8 1 1 1.5"></path>
        <path d="M22 22v-4h-4"></path>
        <path d="m22 18-1.5 1.5c-.9.9-2.1 1.5-3.5 1.5s-2.6-.6-3.5-1.5c-.4-.4-.8-1-1-1.5"></path>
      </svg> -->
          <svg class=" h-4 w-4 text-gray-500 dark:text-gray-200" fill="none" height="24" stroke="currentColor"
            stroke-linecap="round" stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24" width="24"
            xmlns="http://www.w3.org/2000/svg">
            <path
              d="M19 14c1.49-1.46 3-3.21 3-5.5A5.5 5.5 0 0 0 16.5 3c-1.76 0-3 .5-4.5 2-1.5-1.5-2.74-2-4.5-2A5.5 5.5 0 0 0 2 8.5c0 2.3 1.5 4.05 3 5.5l7 7Z">
            </path>
          </svg>
          <svg class=" h-4 w-4 text-gray-500 dark:text-gray-200" fill="none" height="24" stroke="currentColor"
            stroke-linecap="round" stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24" width="24"
            xmlns="http://www.w3.org/2000/svg">
            <path d="M21 15v4a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-4"></path>
            <polyline points="17 8 12 3 7 8"></polyline>
            <line x1="12" x2="12" y1="3" y2="15"></line>
          </svg>
        </div>
        <div class="flex items-center space-x-4">
          <!-- <svg
        class=" h-4 w-4 text-gray-500 dark:text-gray-200"
        fill="none"
        height="24"
        stroke="currentColor"
        stroke-linecap="round"
        stroke-linejoin="round"
        stroke-width="2"
        viewBox="0 0 24 24"
        width="24"
        xmlns="http://www.w3.org/2000/svg"
      >
        <circle cx="12" cy="12" r="1"></circle>
        <circle cx="19" cy="12" r="1"></circle>
        <circle cx="5" cy="12" r="1"></circle>
      </svg> -->
          <svg class=" h-4 w-4 text-gray-500 dark:text-gray-200" fill="none" height="24" stroke="currentColor"
            stroke-linecap="round" stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24" width="24"
            xmlns="http://www.w3.org/2000/svg">
            <path d="m19 21-7-4-7 4V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2v16z"></path>
          </svg>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useDiaryStore } from "@/stores/diary";
import router from "@/router";
const diaryStore = useDiaryStore();

const props = defineProps({
  diary: Object,
});

const showDetail = function () {
  router.push(`/diary/detail/${props.diary.diaryId}`);
};
</script>

<style scoped></style>
