<template>
    <div>
        <h4>Diary Detail</h4>
        <button @click="showUpdate">수정</button>
        <button @click="deleteDiary">삭제</button>
        <img :src="`http://localhost:7777/upload/${diaryStore.selectedDiary.img}`"/>
        <p>{{ diaryStore.selectedDiary.title }}</p>
        <p>{{ diaryStore.selectedDiary.userId }}</p>
        <p>{{ diaryStore.selectedDiary.date }}</p>
        <p>{{ diaryStore.selectedDiary.content }}</p>
        <hr>
        <CommentView/>
        <TodoView/>
    </div>
</template>

<script setup>
    import {onMounted, computed, onBeforeMount, watch} from 'vue'
    import {useRoute} from 'vue-router'
    import {useDiaryStore} from '@/stores/diary'
    import {useUserStore} from '@/stores/user'
    import {useCommentStore} from '@/stores/comment'
    import router from '@/router'
    import CommentView from '@/views/CommentView.vue'
    import TodoView from '@/views/TodoView.vue'
    

    const route = useRoute()
    const diaryId = route.params.diaryId

    const userStore = useUserStore()
    const diaryStore = useDiaryStore()
    const commentStore = useCommentStore()
    
    const selectedDiary = computed(()=>diaryStore.selectedDiary)
    onBeforeMount(() => {
        diaryStore.getDiary(diaryId)
    })

    watch(selectedDiary, ()=>{
        diaryStore.getTodoList(diaryStore.selectedDiary.diaryId)
        commentStore.getCommentList()
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