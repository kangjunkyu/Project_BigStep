<template>
    <div>
        <h4>Create</h4>
        <button @click="createTodo">작성 완료</button>
        <label>Date : </label>
        <input type="text" readonly v-model="todo.date"><br>
        <label>Workout : </label>
        <input type="text" v-model="todo.workout"><br>
        <label>시작 시간 : </label>
        <input type="number" v-model="todo.startHour">시<input type="number" v-model="todo.startMinute">분<br>
        <label>완료 시간 : </label>
        <input type="number" v-model="todo.endHour">시<input type="number" v-model="todo.endMinute">분<br>
    </div>
</template>

<script setup>
    import {ref} from 'vue'
    import {useDiaryStore} from '@/stores/diary'
    import {useUserStore} from '@/stores/user'

    const userStore = useUserStore()
    const diaryStore = useDiaryStore()
    const todo = ref({
        diaryId: diaryStore.selectedDiary.diaryId,
        userId: userStore.loginUser.id,
        date: diaryStore.selectedDiary.date,
        workout: "",
        startHour: 0,
        startMinute: 0,
        endHour: 0,
        endMinute: 0,
    })

    const createTodo = function(){
        diaryStore.createTodo(todo.value)
    }


</script>

<style lang="scss" scoped>

</style>