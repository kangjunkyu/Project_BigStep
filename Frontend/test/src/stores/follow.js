import axios from "axios";
import { ref } from "vue";
import { defineStore } from "pinia";
import { useUserStore } from "@/stores/user";

const REST_FOLLOW_URL = "http://localhost:7777/follow/";

export const useFollowStore = defineStore("follow", () => {
  const userStore = useUserStore();

  const FollowerList = ref([]);
  const getFollowerList = function () {
    axios
      .get(REST_FOLLOW_URL + "followers/" + userStore.loginUser.id)
      .then((response) => {
        FollowerList.value = response.data;
      })
      .catch(() => {});
  };

  const FollowingList = ref([]);
  const getFollowingList = function () {
    axios
      .get(REST_FOLLOW_URL + "followings/" + userStore.loginUser.id)
      .then((response) => {
        FollowingList.value = response.data;
      })
      .catch(() => {});
  };

  const insertFollow = function (id) {
    axios
      .post(REST_FOLLOW_URL + `${userStore.loginUser.id}/${id}`)
      .then((response) => {
        router.push("/follow/follower");
      })
      .catch(() => {});
  };

  const deleteFollow = function (id) {
    axios
      .delete(REST_FOLLOW_URL + `${userStore.loginUser.id}/${id}`)
      .then(() => {
        alert("삭제 완료");
        router.push("/follow/follower");
      })
      .catch(() => {});
  };

  return {
    getFollowerList,
    getFollowingList,
    deleteFollow,
    insertFollow,
    FollowerList,
    FollowingList,
  };
});
