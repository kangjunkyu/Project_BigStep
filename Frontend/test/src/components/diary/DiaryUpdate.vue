<template>
    <div>
        <h4>Diary Update</h4>
        <label>제목</label>
        <input type="text" v-model="diary.title"><br>
        <label>내용</label>
        <textarea v-model="diary.content"></textarea><br>
        <label>날짜</label>
        <input type="text" v-model="diary.date" readonly><br>
        <button @click="updateDiary">수정완료</button>
    </div>
</template>

<script setup>
    import {ref, onMounted} from 'vue'
    import {useRoute} from 'vue-router'
    import {useUserStore} from '@/stores/user'
    import {useDiaryStore} from '@/stores/diary'

    const route = useRoute()
    const diaryId = route.params.diaryId

    const userStore = useUserStore()
    const diaryStore = useDiaryStore()

    onMounted(() => {
        diaryStore.getDiary(diaryId)
    })

    const diary = ref({
        title: diaryStore.selectedDiary.title,
        content: diaryStore.selectedDiary.content,
        date:diaryStore.selectedDiary.date,
        userId: userStore.loginUser.id,
        diaryId: diaryStore.selectedDiary.diaryId,
    })

    const updateDiary = function(){
        diaryStore.updateDiary(diary.value)
    }

</script>

<style scoped>

</style>