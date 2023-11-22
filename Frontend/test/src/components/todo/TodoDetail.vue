<template>
    <div>
        <h4>Todo Detail</h4>
        <p>{{ diaryStore.selectedTodo.workout }}</p>
    </div>
    
</template>

<script setup>
    import { useDiaryStore } from '@/stores/diary';
    const diaryStore = useDiaryStore()
</script>

<style scoped>

</style>