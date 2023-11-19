import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'
import {useDiaryStore} from '@/stores/diary'
import {useUserStore} from '@/stores/user'

const REST_USER_URL = "http://localhost:7777/comment/"

export const useCommentStore = defineStore('comment', () => {
  const diaryStore = useDiaryStore()
  const userStore = useUserStore()

  const commentList = ref([])

  const getCommentList = function(){
    axios.get(`${REST_USER_URL}comments/${diaryStore.selectedDiary.diaryId}`)
    .then((response) => {
        commentList.value = response.data
    })
    .catch(()=>{

    })
  }

  const writeComment = function(input){
    const comment = {
        diaryId: diaryStore.selectedDiary.diaryId,
        userId: userStore.loginUser.id,
        nickname: userStore.loginUser.nickname,
        content: input,
    }

    axios.post(REST_USER_URL, comment)
    .then(()=>{
        alert("댓글 작성 완료")
        getCommentList()
    })
    .catch(()=>{
        
    })
  }

  const deleteComment = function(commentId){
    axios.delete(REST_USER_URL+commentId)
    .then(()=>{
        alert("댓글 삭제 완료")
        getCommentList()
    })
    .catch(()=>{

    })
  }

  const updateComment = function(comment){
    axios.put(REST_USER_URL,comment)
    .then(()=>{
        alert("댓글 수정 완료")
        getCommentList()
    })
    .catch(()=>{

    })
  }


  return {commentList, getCommentList, writeComment, deleteComment, updateComment}
},{persist: true})
