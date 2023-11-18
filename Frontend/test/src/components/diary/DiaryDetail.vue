<template>
    <div>
        <h4>diary detail</h4>
        <button @click="showUpdate">수정</button>
        <button @click="deleteDiary">삭제</button>
        <p>{{ diaryStore.selectedDiary.title }}</p>
        <p>{{ diaryStore.selectedDiary.userId }}</p>
        <p>{{ diaryStore.selectedDiary.date }}</p>
        <p>{{ diaryStore.selectedDiary.content }}</p>
    </div>
</template>

<script setup>
    import {onMounted} from 'vue'
    import {useRoute} from 'vue-router'
    import {useDiaryStore} from '@/stores/diary'
    import router from '@/router'

    const route = useRoute()
    const diaryId = route.params.diaryId

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

</style>