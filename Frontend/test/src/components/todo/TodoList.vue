<template>
    <div>
        <h3>Todo</h3>
        <button>추가</button>
        <TodoListItem v-for="todo in diaryStore.todoList" :key="todo.todoId" :todo="todo"/>
    </div>
</template>

<script setup>
    import {onMounted} from 'vue'
    import {useDiaryStore} from '@/stores/diary'
    import TodoListItem from './TodoListItem.vue';

    const diaryStore = useDiaryStore()

    onMounted(()=>{
        diaryStore.getTodoList(diaryStore.selectedDiary.diaryId)
    })
</script>

<style scoped>

</style>