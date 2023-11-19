<template>
    <div>
        <RouterLink to="/">Home</RouterLink> |
        <RouterLink to="/login" :class="{hidden : userStore.loginUser.id}">Login</RouterLink> | 
        <RouterLink to="/signup" :class="{hidden : userStore.loginUser.id}">SignUp</RouterLink>
        <div :class="{hidden : !userStore.loginUser.id}">
        <a @click="logout">Logout</a> |
        <RouterLink to="/diary/list">Diary</RouterLink> |
        <RouterLink to="/follow">Follow</RouterLink> |
        <RouterLink to="/my-page">MyPage</RouterLink>
        </div>
    </div>
</template>

<script setup>
    import { useUserStore } from '@/stores/user';
    const userStore = useUserStore()

    const logout = function(){
        userStore.logout()
    }
</script>

<style scoped>
    a{
        text-decoration: none;
        color: black;
    }

    .hidden{
        display: none;
    }
</style>