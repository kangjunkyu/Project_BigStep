<template>
  <div class="w-2/5 min-w-[500px] max-w-[500px]">
    <UserPageFollow />
    <!-- <div class="pb-5">유저 가입정보</div>
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
      </div> -->

    <div class="bg-white rounded-lg shadow-lg px-8 py-10 max-w-xl mx-auto">
      <div class="flex items-center justify-between mb-8">
        <div class="flex items-center">
          <img class="h-8 w-8 mr-2" src="@/assets/user-detail.svg" alt="Logo" />
          <div class="text-gray-700 font-semibold text-lg">유저 상세 정보</div>
        </div>
      </div>
      <div class="border-b-2 border-gray-300 pb-8 mb-8">
        <h2 class="text-2xl font-bold mb-4">{{ userStore.loginUser.id }}</h2>
        <div class="text-gray-700 mb-2">{{ userStore.loginUser.name }} / {{ userStore.loginUser.nickname }}</div>
        <div class="text-gray-700 mb-2">{{ userStore.loginUser.email }}</div>
        <div class="text-gray-700 mb-2">{{ userStore.loginUser.address }}</div>
        <div class="text-gray-700">{{ userStore.loginUser.phone }}</div>
      </div>
      <label class="relative inline-flex items-center me-5 cursor-pointer">
        <input type="checkbox" v-model="showBodyProfile" class="sr-only peer" checked>
        <div
          class="w-11 h-6 bg-gray-200 rounded-full peer peer-checked:after:translate-x-full rtl:peer-checked:after:-translate-x-full peer-checked:after:border-white after:content-[''] after:absolute after:top-0.5 after:start-[2px] after:bg-white after:border-gray-300 after:border after:rounded-full after:h-5 after:w-5 after:transition-all dark:border-gray-600 peer-checked:bg-red-600">
        </div>
        <span v-if="!showBodyProfile" class="ms-3 text-sm font-medium text-gray-600">신체 정보</span>
        <span v-else class="ms-3 text-sm font-medium text-red-600">신체 정보</span>
      </label>
      <table v-show="showBodyProfile" class="w-full text-left mb-8">
        <thead>
          <tr>
            <th class="text-gray-700 font-bold uppercase py-2">키</th>
            <th class="text-gray-700 font-bold uppercase py-2">몸무게</th>
            <th class="text-gray-700 font-bold uppercase py-2">나이</th>
            <th class="text-gray-700 font-bold uppercase py-2">성별</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td v-if="userStore.loginUser.height !== 0" class="py-4 text-gray-700">{{ userStore.loginUser.height }}</td>
            <td v-else class="py-4 text-gray-700">미입력</td>
            <td v-if="userStore.loginUser.weight" class="py-4 text-gray-700">{{ userStore.loginUser.weight }}</td>
            <td v-else class="py-4 text-gray-700">미입력</td>
            <td v-if="userStore.loginUser.age" class="py-4 text-gray-700">{{ userStore.loginUser.age }}</td>
            <td v-else class="py-4 text-gray-700">미입력</td>
            <td v-if="userStore.loginUser.gender === 1" class="py-4 text-gray-700">남성</td>
            <td v-else-if="userStore.loginUser.gender === 2" class="py-4 text-gray-700">여성</td>
            <td v-else-if="userStore.loginUser.gender === 3" class="py-4 text-gray-700">선택안함</td>
            <td v-else class="py-4 text-gray-700">미입력</td>
          </tr>
        </tbody>
      </table>

    </div>
  </div>
  <br />

  <div class="">
    <button @click="showUpdate" class="bg-blue-400 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-sm mr-5">
      정보 수정
    </button>
    <button @click="showUpdate" class="bg-red-400 hover:bg-red-700 text-white font-bold py-2 px-4 rounded-sm">
      회원 탈퇴
    </button>
  </div>
  <br />
  <button
    class="flex flex-row rounded-md bg-white font-bold px-4 py-2 text-green-500 align-middle border border-2 border-green-500">
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

const showBodyProfile = ref(false)

</script>
  
<style scoped></style>