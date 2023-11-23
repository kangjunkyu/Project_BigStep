<template>
    <form
      @submit.prevent="writeDiary"
      style="background-color: darkgray; padding: 40px"
    >
      <div class="mb-6">
        <label
          for="email"
          class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
          >Title</label
        >
        <input
          v-model="diary.title"
          type="text"
          id="text"
          class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
          placeholder="title"
          required
        />
      </div>
      <div class="mb-6">
        <label
          for="message"
          class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
          >Content</label
        >
        <textarea
          v-model="diary.content"
          id="message"
          rows="4"
          class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
          placeholder="Write your thoughts here..."
        ></textarea>
      </div>
      <div class="mb-6">
        <label
          for="date"
          class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
          >Date</label
        >
        <input
          v-model="diary.date"
          type="date"
          id="date"
          class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
          required
          placeholder="date"
        />
      </div>
      <!-- <div class="flex items-start mb-6"></div> -->
      <input type="file" id="photo" accept="image/*" @change="getFile" /><br />
      <br />
      <button
        type="submit"
        class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
      >
        Submit
      </button>
    </form>
  </template>
  
  <script setup>
  import { ref } from "vue";
  import { useDiaryStore } from "@/stores/diary";
  import { useUserStore } from "@/stores/user";
  import { useRoute} from 'vue-router'

  const userStore = useUserStore();
  const diaryStore = useDiaryStore();
  
  const route = useRoute();
  
  const diary = ref({
    title: "",
    content: "",
    date: `${route.params.year}-${Number(route.params.month)+1}-${route.params.day}`,
    userId: userStore.loginUser.id,
  });
  
  const file = ref({});
  const getFile = function () {
    var photo = document.getElementById("photo");
    file.value = photo.files[0];
    console.log(typeof file.value);
  };
  const writeDiary = function () {
    var frm = new FormData();
    frm.append("title", diary.value.title);
    frm.append("content", diary.value.content);
    frm.append("date", diary.value.date);
    frm.append("userId", diary.value.userId);
    if (file.value) {
      frm.append("file", file.value);
    }
    // console.log(frm)
    diaryStore.writeDiary(frm);
    // diaryStore.writeDiary(frm)
  };
  </script>
  
  <style scoped></style>
  