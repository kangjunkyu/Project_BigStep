<template>
  <div>
    <div class="totalForm">
      <FollowingDiaryListItem
        v-for="diary in followingDiaryList"
        :key="diary.diaryId"
        :diary="diary"
      />
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, computed } from "vue";
import { useFollowStore } from "@/stores/follow";
import FollowingDiaryListItem from "./followingDiaryListItem.vue";
const followStore = useFollowStore();

const followingDiaryList = computed(() => followStore.FollowingDiaryList);
onMounted(() => {
  followStore.getFollowingDiaryList();
});
</script>

<style scoped>
.totalForm {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: flex-start;
}
</style>
