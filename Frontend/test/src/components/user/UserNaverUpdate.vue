<template>
    <div>
        <p>Naver Update Pages</p>
    </div>
</template>

<script>
    import router from '@/router'
    import {useUserStore} from '@/stores/user'
    

    export default{
        mounted(){
            const userStore = useUserStore()
            const naver_id_login = new window.naver_id_login("VuKdfgG2Qc1tgI8UjxPb","http://localhost:5173/naverupdate");
            const accessToken = naver_id_login.getAccessToken();

            userStore.updateToken(accessToken)
            router.push("/my-page")
        }
    }
</script>

<style scoped>

</style>