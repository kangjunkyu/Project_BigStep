<template>
    <div>
        <h4>Diary Detail</h4>
        <button @click="showUpdate">수정</button>
        <button @click="deleteDiary">삭제</button>
        <p>{{ diaryStore.selectedDiary.title }}</p>
        <p>{{ diaryStore.selectedDiary.userId }}</p>
        <p>{{ diaryStore.selectedDiary.date }}</p>
        <p>{{ diaryStore.selectedDiary.content }}</p>
        <hr>
        <h4>Comment</h4>
        <CommentWrite/>
        <CommentList/>
        <TodoList/>
    </div>
</template>

<script setup>
    import {onMounted, computed} from 'vue'
    import {useRoute} from 'vue-router'
    import {useDiaryStore} from '@/stores/diary'
    import {useUserStore} from '@/stores/user'
    import router from '@/router'
    import CommentWrite from '../comment/CommentWrite.vue'
    import CommentList from '../comment/CommentList.vue'
    import TodoList from '@/components/todo/TodoList.vue'

    const route = useRoute()
    const diaryId = route.params.diaryId

    const userStore = useUserStore()
    const diaryStore = useDiaryStore()

    onMounted(() => {
        diaryStore.getDiary(diaryId)
    })
    
    
    const showUpdate = function() {
        router.push("/diary/update/"+diaryStore.selectedDiary.diaryId)
    }

    const deleteDiary = function() {
        diaryStore.deleteDiary(diaryStore.selectedDiary.diaryId)
    }


</script>

<style scoped>
    .hidden{
        display: none;
    }
</style>