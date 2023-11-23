<template>
  <div class="flex flex-row gap-24">
    
    <div class="flex flex-col">
    <VDatePicker :is-dark="isDark" title-position="left" :attributes="attr"
    v-model="date" mode="date">
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
    </VDatePicker>
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

const date = ref(new Date());

const showWrite = function () {
  console.log(date.value.getDate())
  // router.push({name: 'diaryWriteWithDate', params: {year: date.value.getFullYear(), month:date.value.getMonth(), day:date.value.getDate()}}, );
  router.push(`/diary/write/${date.value.getFullYear()}/${date.value.getMonth()}/${date.value.getDate()}`)
  // router.push(`/diary/write/${date.value}`)
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
