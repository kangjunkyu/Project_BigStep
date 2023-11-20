<template>
    <div>
        <h4>User Page Main</h4>
        <button @click="showUpdate">정보 수정</button>
    </div>
</template>

<script setup>
    import router from '@/router'

    const showUpdate = function(){
        router.push(`/my-page/update`)
    }
</script>

<style scoped>

</style>