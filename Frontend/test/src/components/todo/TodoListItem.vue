<template>
    <div>
        <span :class="{complete : todo.complete}" @click="showDetail">
            {{ todo.workout }} / {{ todo.startHour }}:{{ todo.startMinute }} ~ {{ todo.endHour }}:{{ todo.endMinute }}</span>
        <button @click="changeComplete">완료</button>
        <button @click="showUpdate">수정</button>
        <button @click="deleteTodo">삭제</button>
    </div>
</template>

<script setup>
    import router from '@/router'
    import {useDiaryStore} from '@/stores/diary'

    const diaryStore = useDiaryStore()
    const props = defineProps({
        todo: Object,
    })

    const changeComplete = function(){
        const todo = {
            todoId: props.todo.todoId,
            diaryId: props.todo.diaryId,
            userId: props.todo.userId,
            date: props.todo.date,
            workout: props.todo.workout,
            startHour: props.todo.startHour,
            startMinute: props.todo.startMinute,
            endHour: props.todo.endHour,
            endMinute: props.todo.endMinute,
            complete: !props.todo.complete,
        }

        diaryStore.updateTodo(todo)
    }

    const showDetail = function(){
        router.push({name: 'tododetail', params:{todoId: props.todo.todoId}})
    }

    const showUpdate = function(){
        router.push({name: 'todoupdate', params:{todoId: props.todo.todoId}})
    }

    const deleteTodo = function(){
        diaryStore.deleteTodo(props.todo.todoId, props.todo.diaryId)
    }
</script>

<style scoped>
    .complete{
        text-decoration: line-through;
    }
</style>