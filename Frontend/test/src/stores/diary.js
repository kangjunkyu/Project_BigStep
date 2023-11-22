import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";
import { useUserStore } from "@/stores/user";

const REST_DIARY_URL = "http://localhost:7777/diary/";
const REST_TODO_URL = "http://localhost:7777/todo/";

export const useDiaryStore = defineStore(
  "diary",
  () => {
    const userStore = useUserStore();

    const diaryList = ref([]);
    const getList = function () {
      axios
        .get(REST_DIARY_URL + "diarys/" + userStore.loginUser.id)
        .then((response) => {
          diaryList.value = response.data;
        })
        .catch(() => {});
    };

    const selectedDiary = ref({});
    const getDiary = function (diaryId) {
      axios.get(REST_DIARY_URL + diaryId).then((response) => {
        selectedDiary.value = response.data;
      });
    };

    const writeDiary = function (frm) {
      axios
        .post(REST_DIARY_URL, frm, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        })
        .then(() => {
          alert("작성 완료");
          router.push("/diary/list");
        })
        .catch(() => {});
    };

    const updateDiary = function (diary) {
      axios
        .put(REST_DIARY_URL, diary)
        .then(() => {
          alert("수정 완료");
          router.push("/diary/detail/" + diary.diaryId);
        })
        .catch(() => {});
    };

    const deleteDiary = function (diaryId) {
      axios
        .delete(REST_DIARY_URL + diaryId)
        .then(() => {
          alert("삭제 완료");
          router.push("/diary/list");
        })
        .catch(() => {});
    };

    const todoList = ref([]);
    const getTodoList = function (diaryId) {
      axios
        .get(REST_TODO_URL + `todos/${diaryId}`)
        .then((response) => {
          todoList.value = response.data;
        })
        .catch(() => {});
    };

    const selectedTodo = ref({});
    const getTodo = function (todoId) {
      axios
        .get(REST_TODO_URL + todoId)
        .then((response) => {
          selectedTodo.value = response.data;
        })
        .catch(() => {});
    };

    const createTodo = function (todo) {
      axios
        .post(REST_TODO_URL, todo)
        .then(() => {
          alert("생성 완료");
          router.push({ name: "todolist" });
        })
        .catch(() => {});
    };

    const updateTodo = function (todo) {
      axios
        .put(REST_TODO_URL, todo)
        .then(() => {
          alert("test");
          getTodoList(todo.diaryId);
          router.push({ name: "todolist" });
        })
        .catch(() => {});
    };

    const deleteTodo = function (todoId, diaryId) {
      axios
        .delete(REST_TODO_URL + todoId)
        .then(() => {
          alert("삭제 완료");
          getTodoList(diaryId);
        })
        .catch(() => {});
    };

    return {
      diaryList,
      getList,
      selectedDiary,
      getDiary,
      writeDiary,
      updateDiary,
      deleteDiary,
      todoList,
      selectedTodo,
      getTodo,
      getTodoList,
      createTodo,
      updateTodo,
      deleteTodo,
    };
  },
  { persist: true }
);
