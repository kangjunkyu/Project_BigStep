<template>
    <li>
        <span>{{ props.comment.userId }} / {{ props.comment.content }}</span>
        <span v-show="userStore.loginUser.id === comment.userId">
            <button @click="showUpdate" v-show="!isUpdate">수정</button>
            <div v-show="isUpdate">
                <textarea v-model="comment.content" @keyup.enter="updateComment"></textarea>
                <button @click="updateComment">수정 완료</button>
            </div>
            <button @click="deleteComment" v-show="!isUpdate">삭제</button>
        </span>
    </li>
</template>

<script setup>
    import {ref} from 'vue'
    import {useUserStore} from '@/stores/user'
    import { useCommentStore } from '@/stores/comment';
    const userStore = useUserStore()
    const commentStore = useCommentStore()

    const isUpdate = ref(false)
    

    const props = defineProps({
        comment: Object,
    })

    const comment = ref({
        commentId: props.comment.commentId,
        diaryId: props.comment.diaryId,
        userId: props.comment.userId,
        nickname: props.comment.nickname,
        content: props.comment.content,
    })

    const deleteComment = function(){
        commentStore.deleteComment(props.comment.commentId)
    }

    const showUpdate = function(){
        isUpdate.value = !isUpdate.value
    }

    const updateComment = function(){
        commentStore.updateComment(comment.value)
        isUpdate.value = !isUpdate.value
    }
</script>

<style scoped>

</style>