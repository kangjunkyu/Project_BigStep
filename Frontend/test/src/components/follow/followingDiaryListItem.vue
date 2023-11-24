<template>
  <div class="shadow-lg ImgCard" @click="showDetail">
    <img v-if="diary.img" :src="`http://localhost:7777/upload/${diary.img}` " />
    <img v-else src="@/assets/곰발바닥.png" alt="" />
    <div class="ment">
      <!-- {{ diary.userId }}
      {{ diary.title }} -->
    </div>
  </div>
</template>

<script setup>
import router from "@/router";

const props = defineProps({
  diary: Object,
});

const showDetail = function () {
  router.push(`/diary/detail/${props.diary.diaryId}`);
};
</script>

<style scoped>
.ImgCard {
  display: flex;
  flex-direction: column;
  width: 250px;
  height: 250px;
  margin: 30px;
}
.ment {
  display: flex;
  flex-direction: column;
}
</style>
