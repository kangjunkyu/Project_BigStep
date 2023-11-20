<template>
    <div>
        <h4>Diary Write</h4>
        <label>제목</label>
        <input type="text" v-model="diary.title"><br>
        <label>내용</label>
        <textarea v-model="diary.content"></textarea><br>
        <label>날짜</label>
        <input type="text" v-model="diary.date"><br>
        <input type="file" id="photo" accept="image/*" @change="getFile"><br>
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

    const file = ref({})
    const getFile = function(){
        var photo = document.getElementById("photo")
        file.value = photo.files[0]
        console.log(typeof file.value)
    }
    const writeDiary = function(){
        var frm = new FormData();
        frm.append("title", diary.value.title)
        frm.append("content", diary.value.content)
        frm.append("date", diary.value.date)
        frm.append("userId",diary.value.userId)
        frm.append("file", file.value)
        // console.log(frm)
        diaryStore.writeDiary(frm)
        // diaryStore.writeDiary(frm)
    }

</script>

<style scoped>

</style>