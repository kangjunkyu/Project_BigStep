import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import LoginView from '@/views/LoginView.vue'
import DiaryView from '@/views/DiaryView.vue'
import FollowView from '@/views/FollowView.vue'
import MyPageView from '@/views/MyPageView.vue'
import SearchView from '@/views/SearchView.vue'
import DiaryList from '@/components/diary/DiaryList.vue'
import DiaryDetail from '@/components/diary/DiaryDetail.vue'
import DiaryWrite from '@/components/diary/DiaryWrite.vue'
import DiaryUpdate from '@/components/diary/DiaryUpdate.vue'
import SearchResult from '@/components/search/SearchResult.vue'



const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView
    },
    {
      path: '/diary',
      name: 'diary',
      component: DiaryView,
      children:[
        {
          path: 'list',
          name: 'diaryList',
          component: DiaryList
        },
        {
          path: 'detail/:diaryId',
          name: 'diaryDetail',
          component: DiaryDetail
        },
        {
          path: 'write',
          name: 'diaryWrite',
          component: DiaryWrite
        },
        {
          path: 'update/:diaryId',
          name: 'diaryUpdate',
          component: DiaryUpdate
        },
      ]
    },
    {
      path: '/follow',
      name: 'follow',
      component: FollowView
    },
    {
      path: '/my-page',
      name: 'mypage',
      component: MyPageView
    },
    {
      path: '/search',
      name: 'search',
      component: SearchView,
      children: [
        {
          path: "result",
          name: "searchResult",
          component: SearchResult
        },
      ]
    },


  ]
})

export default router
