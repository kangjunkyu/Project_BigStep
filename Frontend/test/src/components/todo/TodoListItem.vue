<template>
    <div>
        <span :class="{complete : todo.complete}" @click="showDetail">
            {{ todo.workout }} / {{ todo.startHour }}:{{ todo.startMinute }} ~ {{ todo.endHour }}:{{ todo.endMinute }}</span>
        <button @click="changeComplete">완료</button>
        <button>삭제</button>
    </div>
</template>

<script setup>
    import router from '@/router'

    const props = defineProps({
        todo: Object,
    })

    const changeComplete = function(){
        props.todo.complete = !props.todo.complete
    }

    const showDetail = function(){
        router.push("/diary/todo/detail")
    }
</script>

<style scoped>
    .complete{
        text-decoration: line-through;
    }
</style>