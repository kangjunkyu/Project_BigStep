<template>
  <div>
    <li>
      <p>{{ following }}</p>
    </li>
  </div>
</template>

<script setup>
defineProps({
  following: String,
});
</script>

<style scoped></style>
