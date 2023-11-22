<template>
  <div>
    <HeaderNav />
    <div class="mainbackground">
      <RouterView />
    </div>
  </div>
</template>

<script setup>
import HeaderNav from "../components/common/HeaderNav.vue";
</script>

<style scoped></style>
