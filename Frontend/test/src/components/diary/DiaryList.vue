<template>
  <div class="flex flex-row gap-24">
    
    <div class="flex flex-col">
    <VCalendar :is-dark="isDark" title-position="left" :attributes="attr">
    <template #footer>
      <div class="w-full px-4 pb-3">
        <button
          class="bg-indigo-600 hover:bg-indigo-700 text-white font-bold w-full px-3 py-1 rounded-md"
          @click="showWrite"
        >
          작성
        </button>
      </div>
    </template>
    </VCalendar>
    </div>

    <div class="flex flex-row flex-wrap gap-10">
    
      <DiaryListItem
        v-for="diary in diaryList"
        :key="diary.diaryId"
        :diary="diary"
      />
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, computed } from "vue";
import { useDiaryStore } from "@/stores/diary";
import DiaryListItem from "@/components/diary/DiaryListItem.vue";
import router from "@/router";

const diaryStore = useDiaryStore();

const diaryList = computed(() => diaryStore.diaryList)

onMounted(() => {
  diaryStore.getList();
});

const isDark = computed(() => localStorage.getItem('color-theme') === 'dark')

const showWrite = function () {
  router.push("/diary/write");
};

// const attr = ref([
// { 
//     dot: 'green',
//     dates: "2023-11-20 00:00:00",
//     popover:{
//       label: "test"
//     }
//   },
// ])

const attr = computed(() => [
  ...diaryList.value.map(diary => ({
    dates: diary.date,
    dot: {
      color: "green",
    },
    popover:{
      label: diary.title,
      visibility:'focus'
    },
    
  }))
])


</script>

<style scoped></style>
