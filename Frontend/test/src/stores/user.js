import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

const REST_USER_URL = "http://localhost:7777/user/";

export const useUserStore = defineStore(
  "user",
  () => {
    const loginUser = ref({});
    const login = function (user) {
      axios
        .post(REST_USER_URL + "login", user)
        .then((response) => {
          loginUser.value = response.data;
          router.push({ name: "diaryList" });
        })
        .catch(() => {
          alert("로그인 실패");
        });
    };

    const logout = function () {
      axios.post(REST_USER_URL + "logout").then(() => {
        loginUser.value = {};
        router.push({ name: "home" });
      });
    };

    const searchWord = ref("");
    const searchResult = ref([]);
    const search = function (word) {
      axios
        .get(REST_USER_URL + `users/${word}`)
        .then((response) => {
          searchResult.value = response.data;
          searchWord.value = word;
          router.push("/search/result");
        })
        .catch(() => {});
    };

    const signupUser = function (user) {
      axios
        .post(REST_USER_URL, user)
        .then(() => {
          alert("회원가입 완료");
          router.push("/");
        })
        .catch(() => {});
    };

    const accessToken = ref("");
    const checkToken = function (token) {
      axios
        .get(REST_USER_URL + `/uid/${token}`)
        .then((response) => {
          console.log(response.data);
          // 로그인
          login(response.data);
        })
        .catch((error) => {
          if (error.response.status === 401) {
            console.log("401 에러");
            alert("연동된 계정이 없습니다!!");
            router.push("/");
          } else {
            console.log("500 에러");
          }
        });
    };

    const updateToken = function (token) {
      console.log(token);
      loginUser.value.uid = token;
      updateUser(loginUser.value);
    };

    const updateUser = function (user) {
      axios
        .put(REST_USER_URL, user)
        .then(() => {
          loginUser.value = user;
          alert("수정 완료");
          router.push("/my-page");
        })
        .catch(() => {});
    };

    return {
      loginUser,
      login,
      logout,
      search,
      searchWord,
      searchResult,
      signupUser,
      checkToken,
      updateUser,
      accessToken,
      updateToken,
    };
  },
  { persist: true }
);
