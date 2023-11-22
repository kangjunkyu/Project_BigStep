<template>
  <div class="diarycontainer">
    <div
      @click="showDetail"
      class="bg-white border-b dark:bg-gray-800 dark:border-gray-700"
    >
      <br />
      <li style="font-size: 30px; color: white">
        <p>{{ diary.title }}</p>
      </li>
      <li>
        <p>{{ diary.userId }}</p>
      </li>
      <li>
        <p>{{ diary.content }}</p>
      </li>
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

<style scoped>
.diarycontainer {
  padding: 20px;
  margin: 20px;
}
li {
  padding: 10px;
  margin: 10px;
}
</style>
