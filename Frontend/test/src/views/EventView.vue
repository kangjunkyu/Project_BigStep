<template>
  <p class="text-4xl font-bold">Event</p>
  <div class="eventview">
    <Event />
  </div>
</template>

<script setup>
import Event from "../components/common/Event.vue";
</script>

<style scoped>
.eventview {
  display: flex;
  flex-direction: column;
  justify-content: center;
  justify-items: center;
  align-items: center;
}
</style>
