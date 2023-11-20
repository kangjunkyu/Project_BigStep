<template>
    <div>
        <h4>Update</h4>
        <button @click="updateTodo">수정 완료</button>
        <label>Date : </label>
        <input type="text" readonly v-model="selectedTodo.date"><br>
        <label>Workout : </label>
        <input type="text" v-model="selectedTodo.workout"><br>
        <label>시작 시간 : </label>
        <input type="number" v-model="selectedTodo.startHour">시<input type="number" v-model="selectedTodo.startMinute">분<br>
        <label>완료 시간 : </label>
        <input type="number" v-model="selectedTodo.endHour">시<input type="number" v-model="selectedTodo.endMinute">분<br>
    </div>
</template>

<script setup>
    import {ref, onMounted, computed} from 'vue'
    import {useDiaryStore} from '@/stores/diary'
    import {useUserStore} from '@/stores/user'
    import { useRoute } from 'vue-router';

    const route = useRoute()
    const diaryStore = useDiaryStore()
    const userStore = useUserStore()

    const todoId = route.params.todoId

    const selectedTodo = computed(()=>diaryStore.selectedTodo)
    const todo = ref({
        todoId: todoId,
        diaryId: diaryStore.selectedDiary.diaryId,
        userId: userStore.loginUser.id,
        date: selectedTodo.value.date,
        workout: selectedTodo.value.workout,
        startHour: selectedTodo.value.startHour,
        startMinute: selectedTodo.value.startMinute,
        endHour: selectedTodo.value.endHour,
        endMinute: selectedTodo.value.endMinute,
    })

    onMounted(() => {
        diaryStore.getTodo(todoId)
    })

    const updateTodo = function(){
        diaryStore.updateTodo(selectedTodo.value)
    }
    

</script>

<style scoped>

</style>