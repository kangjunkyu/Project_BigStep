<template>
    <div>
        <h4>User Page Main</h4>
        <button @click="showUpdate">정보 수정</button>
        <br><br>
        <span>네이버 연동</span>
        <UserUpadateNaver/>
    </div>
</template>

<script setup>
    import router from '@/router'
    import UserUpadateNaver from '@/components/user/UserUpdateNaver.vue'

    const showUpdate = function(){
        router.push(`/my-page/update`)
    }
</script>

<style scoped>

</style>