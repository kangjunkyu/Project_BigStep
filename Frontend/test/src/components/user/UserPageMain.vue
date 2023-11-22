<template>
    <div>
        <br>
        <UserPageFollow/>
        <br>
        <button @click="showUpdate" class="bg-teal-400 hover:bg-teal-700 text-white font-bold py-2 px-4 rounded-full">정보 수정</button>
        <br><br>
        <div v-show="!userStore.loginUser.uid">
            <span>네이버 연동</span>
            <UserUpadateNaver/>
        </div>
    </div>
</template>

<script setup>
    import router from '@/router'
    import UserPageFollow from '@/components/user/UserPageFollow.vue';

    import UserUpadateNaver from '@/components/user/UserUpdateNaver.vue'
    import {useUserStore} from '@/stores/user'

    const userStore = useUserStore()
    const showUpdate = function(){
        router.push(`/my-page/update`)
    }
</script>

<style scoped>

</style>