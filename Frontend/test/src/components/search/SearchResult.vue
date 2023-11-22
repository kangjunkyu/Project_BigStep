<template>
    <div class="grid grid-cols-2 gap-4">
        <p v-if="userStore.searchResult.length === 0">검색된 유저가 없습니다.</p>
        <template v-else>
            <template v-for="user in userStore.searchResult" :key="user.id">
                <SearchResultItem v-if="user.id !== userStore.loginUser.id" :user="user"/>
            </template>
        </template>
    </div>
</template>

<script setup>
    import SearchResultItem from '@/components/search/SearchResultItem.vue';
    import { useUserStore } from '@/stores/user';
    const userStore = useUserStore();
</script>

<style scoped>

</style>