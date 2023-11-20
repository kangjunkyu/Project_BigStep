<template>
  <div>
    <li>
      <p>{{ follower }}</p>
    </li>
  </div>
</template>

<script setup>
defineProps({
  follower: String,
});
</script>

<style scoped></style>
