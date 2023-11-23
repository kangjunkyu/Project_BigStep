<template>
  <p class="text-4xl font-bold">Weather</p>
  <div class="eventview">
    <Event />
  </div>
</template>

<script setup>
import Event from "../components/common/Event.vue";
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&family=Noto+Sans+KR:wght@300&display=swap");
.eventview {
  display: flex;
  flex-direction: column;
  justify-content: center;
  justify-items: center;
  align-items: center;
}
</style>
