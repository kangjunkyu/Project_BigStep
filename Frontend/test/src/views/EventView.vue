<template>
  <div class="eventview">
    <h3>event View</h3>
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
