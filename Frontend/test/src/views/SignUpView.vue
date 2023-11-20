<template>
    <div>
        <h3>Sign Up</h3>
        <label>ID : </label>
        <input type="text" v-model="user.id"><br>
        <label>PW : </label>
        <input type="password" v-model="user.pw"><br>
        <label>PW check: </label>
        <input type="password" v-model="pw_check"><br>
        <br>
        <label>Name : </label>
        <input type="text" v-model="user.name"><br>
        <label>Nickname : </label>
        <input type="text" v-model="user.nickname"><br>
        <label>E-mail : </label>
        <input type="email" v-model="user.email"><br>
        <label>Phone : </label>
        <input type="text" v-model="user.phone"><br>
        <label>Address : </label>
        <input type="text" v-model="user.address"><br>
        <br>
        <label>height : </label>
        <input type="text" v-model="user.height"><br>
        <label>weight : </label>
        <input type="text" v-model="user.weight"><br>
        <label>age : </label>
        <input type="text" v-model="user.age"><br>
        <label>gender : </label>
        <select v-model="user.gender">
            <option value=1>남성</option>
            <option value=2>여성</option>
            <option value=3>선택안함</option>
        </select>

        <button @click="signupUser">가입</button>
    </div>
</template>

<script setup>
    import {ref} from 'vue'
    import {useUserStore} from '@/stores/user'

    const userStore = useUserStore()

    const user = ref({
        id: "",
        pw: "",
        name: "",
        nickname: "",
        email: "",
        phone: "",
        address: "",
        height: 0,
        weight: 0,
        age: 0,
        gender: 3
    })

    const pw_check = ref("")

    const signupUser = function(){
        if(user.value.pw !== pw_check.value){
            alert("비밀번호를 확인하세요")
        }else{
            userStore.signupUser(user.value)
        }
    }
</script>

<style scoped>

</style>