<template>
    <li>
        <RouterLink :to="`/diary/detail/${diary.diaryId}`">
            <p>{{ diary.title }} / {{ diary.userId }} / {{ diary.content }}</p>
        </RouterLink>
    </li>
</template>

<script setup>
    defineProps({
        diary: Object,
    })

</script>

<style scoped>

</style>