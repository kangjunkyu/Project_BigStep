<template>
    <div>
        <button @click="showCreate">추가</button>
        <TodoListItem v-for="todo in todoList" :key="todo.todoId" :todo="todo"/>
    </div>
</template>

<script setup>
    import {onMounted, computed, watch} from 'vue'
    import {useDiaryStore} from '@/stores/diary'
    import router from '@/router'
    import TodoListItem from '@/components/todo/TodoListItem.vue';

    const diaryStore = useDiaryStore()

    const todoList = computed(() => diaryStore.todoList)
    onMounted(()=>{
        diaryStore.getTodoList(diaryStore.selectedDiary.diaryId)
    })
    
    const showCreate = function(){
        router.push({name: 'todocreate'})
    }
</script>

<style scoped>

</style>