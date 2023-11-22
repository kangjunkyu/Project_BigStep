<template>
    <div class="w-2/5 min-w-[450px]">
      <UserPageFollow />
      <div class="pb-5">유저 가입정보</div>
      <div class="p-4 text-lg border border-2 border-gray-200 p-4 w-30">
        <div>id : {{ userStore.loginUser.id }}</div>
        <div class="">
          name : {{ userStore.loginUser.name }} / nickname :
          {{ userStore.loginUser.nickname }}
        </div>
        <div>email : {{ userStore.loginUser.email }}</div>
        <div>phone : {{ userStore.loginUser.phone }}</div>
      </div>
      <br />
      <div>신체정보</div>
      <br />
      <div class="text-lg border border-2 border-gray-200 p-4 w-30">
        <div>height : {{ userStore.loginUser.height }}</div>
        <div>weight : {{ userStore.loginUser.weight }}</div>
        <div>age : {{ userStore.loginUser.age }}</div>
      </div>
    </div>
    <br />
    <div class="">
      <button
        @click="showUpdate"
        class="bg-blue-400 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-sm mr-5"
      >
        정보 수정
      </button>
      <button
        @click="showUpdate"
        class="bg-red-400 hover:bg-red-700 text-white font-bold py-2 px-4 rounded-sm"
      >
        회원 탈퇴
      </button>
    </div>
    <br />
    <button
      class="flex flex-row rounded-md bg-white font-bold px-4 py-2 text-green-500 align-middle border border-2 border-green-500"
    >
      <div class="flex justify-center items-center gap-2">
        <UserUpadateNaver />
        <div class="text-lg">네이버 연동</div>
      </div>
    </button>
  </template>
  
  <script setup>
  import router from "@/router";
  import { ref } from "vue";
  import UserPageFollow from "@/components/user/UserPageFollow.vue";
  
  import UserUpadateNaver from "@/components/user/UserUpdateNaver.vue";
  import { useUserStore } from "@/stores/user";
  
  const userStore = useUserStore();
  const showUpdate = function () {
    router.push(`/my-page/update`);
  };
  const user = ref({
    id: userStore.loginUser.id,
    pw: userStore.loginUser.pw,
    name: userStore.loginUser.name,
    nickname: userStore.loginUser.nickname,
    email: userStore.loginUser.email,
    phone: userStore.loginUser.phone,
    address: userStore.loginUser.address,
    uid: userStore.loginUser.uid,
    height: userStore.loginUser.height,
    weight: userStore.loginUser.weight,
    age: userStore.loginUser.age,
    gender: userStore.loginUser.gender,
    public: userStore.loginUser.public,
  });
  </script>
  
  <style scoped></style>