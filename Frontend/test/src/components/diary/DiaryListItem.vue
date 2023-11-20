<template>
    <li>
        <p @click="showDetail">{{ diary.title }} / {{ diary.userId }} / {{ diary.content }}</p>
    </li>
</template>

<script setup>
    import {useDiaryStore} from '@/stores/diary'
    import router from '@/router'
    const diaryStore = useDiaryStore()

    const props = defineProps({
        diary: Object,
    })

    const showDetail = function(){
        router.push(`/diary/detail/${props.diary.diaryId}`)
    }
    
</script>

<style scoped>

</style>