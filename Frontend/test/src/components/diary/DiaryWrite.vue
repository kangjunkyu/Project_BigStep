<template>
    <div>
        <h4>Diary Write</h4>
        <label>제목</label>
        <input type="text" v-model="diary.title"><br>
        <label>내용</label>
        <textarea v-model="diary.content"></textarea><br>
        <label>날짜</label>
        <input type="text" v-model="diary.date"><br>
        <button @click="writeDiary">작성완료</button>
    </div>
</template>

<script setup>
    import {ref} from 'vue'
    import {useDiaryStore} from '@/stores/diary'
    import {useUserStore} from '@/stores/user'

    const userStore = useUserStore()
    const diaryStore = useDiaryStore()

    const diary = ref({
        title : "",
        content : "",
        date : "",
        userId: userStore.loginUser.id,
    })

    const writeDiary = function(){
        diaryStore.writeDiary(diary.value)
    }

</script>

<style scoped>

</style>