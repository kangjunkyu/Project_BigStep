<template>
    <div>
        <textarea placeholder="댓글 작성" cols="40" v-model="content" @keyup.enter="writeComment"></textarea>
        <button @click="writeComment">작성</button>
    </div>
</template>

<script setup>
    import {ref} from 'vue'
    import { useCommentStore } from '@/stores/comment';

    const commentStore = useCommentStore()

    const content = ref("")

    const writeComment = function(){
        commentStore.writeComment(content.value)
        content.value = ""
    }
</script>

<style scoped>

</style>