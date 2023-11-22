<template>
  <div style="display: flex; flex-direction: column; align-items: center">
    <div
      style="
        background-color: gray;
        width: 900px;
        height: 740px;
        padding-left: 60px;
        padding-right: 60px;
        padding-top: 30px;
      "
    >
      <form>
        <div class="grid gap-4 mb-6 md:grid-cols-2">
          <div>
            <label
              for="first_name"
              class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >ID</label
            >
            <input
              type="text"
              v-model="user.id"
              id="first_name"
              class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              required
            />
          </div>
          <div>
            <label
              for="name"
              class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >NAME</label
            >
            <input
              type="text"
              v-model="user.name"
              id="name"
              class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              required
            />
          </div>
          <div>
            <label
              for="password"
              class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >PW</label
            >
            <input
              type="password"
              v-model="user.pw"
              id="password"
              class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              required
            />
          </div>
          <div>
            <label
              for="pw_check"
              class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >PW_CHECK</label
            >
            <input
              type="password"
              v-model="pw_check"
              id="pw_check"
              class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            />
          </div>
          <div>
            <label
              for="phone"
              class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >PHONE NUMBER</label
            >
            <input
              type="tel"
              v-model="user.phone"
              id="phone"
              class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
              required
            />
          </div>
          <div>
            <label
              for="nickname"
              class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >NICKNAME</label
            >
            <input
              type="text"
              v-model="user.nickname"
              id="nickname"
              class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              required
            />
          </div>
        </div>

        <div class="mb-6">
          <label
            for="email"
            class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
            >Email address</label
          >
          <input
            type="email"
            v-model="user.email"
            id="email"
            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            required
          />
        </div>
        <div class="mb-6">
          <label
            for="address"
            class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
            >Address</label
          >
          <input
            type="text"
            v-model="user.address"
            id="address"
            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            required
          />
        </div>

        <div class="grid gap-6 mb-6 md:grid-cols-4">
          <div>
            <label
              for="height"
              class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >height</label
            >
            <input
              type="num"
              v-model="user.height"
              id="height"
              class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              required
            />
          </div>
          <div>
            <label
              for="weight"
              class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >weight</label
            >
            <input
              type="num"
              v-model="user.weight"
              id="weight"
              class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              required
            />
          </div>
          <div>
            <label
              for="age"
              class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >age</label
            >
            <input
              type="num"
              v-model="user.age"
              id="age"
              class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              required
            />
          </div>
          <div>
            <label
              for="gender"
              class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >gender</label
            >
            <Select
              id="visitors"
              v-model="user.gender"
              class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            >
              <option value="1">남성</option>
              <option value="2">여성</option>
              <option value="3">선택안함</option>
            </Select>
          </div>

          <div class="isPublic">
            <label
              for="ispublic"
              class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >공개 여부 :
            </label>
            <select
              v-model="user.public"
              id="ispublic"
              class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            >
              <option value="true">공개</option>
              <option value="false">비공개</option>
            </select>
            <br />

            <button
              type="submit"
              @click="signupUser"
              class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
            >
              Submit
            </button>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from "vue";
import { useUserStore } from "@/stores/user";

const userStore = useUserStore();

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

const pw_check = ref(userStore.loginUser.pw);

const updateUser = function () {
  if (user.value.pw !== pw_check.value) {
    alert("비밀번호를 확인하세요!!");
  } else {
    userStore.updateUser(user.value);
  }
};
</script>

<style scoped>
.isPublic {
  /* display: flex;
  flex-direction: row;
  justify-content: end;
  align-items: right; */
}
</style>
