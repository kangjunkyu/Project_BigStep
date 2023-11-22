<template>
  <div>
    <h4>DiaryList</h4>
    <button @click="showWrite">작성</button>
    <ul>
      <DiaryListItem
        v-for="diary in diaryStore.diaryList"
        :key="diary.diaryId"
        :diary="diary"
      />
    </ul>
  </div>
</template>

<script setup>
import { ref, onMounted, computed } from "vue";
import { useDiaryStore } from "@/stores/diary";
import DiaryListItem from "@/components/diary/DiaryListItem.vue";
import router from "@/router";

const diaryStore = useDiaryStore();

onMounted(() => {
  diaryStore.getList();
});

const showWrite = function () {
  router.push("/diary/write");
};
</script>

<style scoped></style>
