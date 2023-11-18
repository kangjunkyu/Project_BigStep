import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'
import { useUserStore } from '@/stores/user'

const REST_DIARY_URL = "http://localhost:7777/diary/"

export const useDiaryStore = defineStore('diary', () => {
  const userStore = useUserStore()

  const diaryList = ref([]);
  const getList = function(){
    axios.get(REST_DIARY_URL+"diarys/"+userStore.loginUser.id)
    .then((response) => {
        diaryList.value = response.data;
    })
    .catch(()=>{
        
    })
  }

  const selectedDiary = ref({})
  const getDiary = function(diaryId) {
    axios.get(REST_DIARY_URL+diaryId)
    .then((response)=>{
      selectedDiary.value = response.data
    })
  }

  const writeDiary = function(diary){
    console.log(diary)
    axios.post(REST_DIARY_URL, diary)
    .then(() => {
      alert("작성 완료")
      router.push("/diary/list")
    })
    .catch(() => {

    })
  }

  const updateDiary = function(diary){
    axios.put(REST_DIARY_URL, diary)
    .then(() => {
      alert("수정 완료")
      router.push("/diary/detail/"+diary.diaryId)
    })
    .catch(()=>{

    })
  }

  const deleteDiary = function(diaryId){
    console.log(diaryId)
    axios.delete(REST_DIARY_URL+diaryId)
    .then(()=>{
      alert("삭제 완료")
      router.push("/diary/list")
    })
    .catch(()=>{

    })
  }

  return {diaryList, getList, selectedDiary, getDiary, writeDiary, updateDiary, deleteDiary}
},{persist: true})
