<template>
    <div>
        <h4>SearchResult</h4>
        <p v-if="userStore.searchResult.length === 0">검색된 유저가 없습니다.</p>
        <div v-else>
            <SearchResultItem v-for="user in userStore.searchResult" :key="user.id" :user="user"/>
        </div>
    </div>
</template>

<script setup>
    import SearchResultItem from '@/components/search/SearchResultItem.vue';
    import { useUserStore } from '@/stores/user';
    const userStore = useUserStore();
</script>

<style scoped>

</style>