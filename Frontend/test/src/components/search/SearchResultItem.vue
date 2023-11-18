<template>
    <li>
        <span>{{ user.id }} / {{ user.name }} / {{ user.email }}</span>
        <button>Follow</button>
        <button>Unfollow</button>
    </li>
</template>

<script setup>
    defineProps({
        user: Object,
    })
</script>

<style scoped>

</style>