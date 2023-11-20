import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import LoginView from '@/views/LoginView.vue'
import SignUpView from '@/views/SignUpView.vue'
import DiaryView from '@/views/DiaryView.vue'
import FollowView from '@/views/FollowView.vue'
import MyPageView from '@/views/MyPageView.vue'
import SearchView from '@/views/SearchView.vue'
import DiaryList from '@/components/diary/DiaryList.vue'
import DiaryDetail from '@/components/diary/DiaryDetail.vue'
import DiaryWrite from '@/components/diary/DiaryWrite.vue'
import DiaryUpdate from '@/components/diary/DiaryUpdate.vue'
import SearchResult from '@/components/search/SearchResult.vue'
import followerList from "@/components/follow/followerList.vue";
import followingList from "@/components/follow/followingList.vue";
import TodoDetail from '@/components/todo/TodoDetail.vue'
import TodoList from '@/components/todo/TodoList.vue'
import TodoCreate from '@/components/todo/TodoCreate.vue'
import TodoUpdate from '@/components/todo/TodoUpdate.vue'



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
      path: '/signup',
      name: 'signup',
      component: SignUpView
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
          component: DiaryDetail,
          children:[
            {
              path: '',
              name: 'todolist',
              component: TodoList,
            },
            {
              path: 'todo/detail/:todoId',
              name: 'tododetail',
              component: TodoDetail,
            },
            {
              path: 'todo/create',
              name: 'todocreate',
              component: TodoCreate,
            },
            {
              path: 'todo/update/:todoId',
              name: 'todoupdate',
              component: TodoUpdate,
            },
          ]

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
        {
          path: 'todo/detail',
          name: 'todoDetail',
          component: TodoDetail
        }
      ]
    },
    {
      path: '/follow',
      name: 'follow',
      component: FollowView,
      children:[
        {
          path: "following",
          name: "following",
          component: followingList,
        },
        {
          path: "follower",
          name: "follower",
          component: followerList,
        },
      ]
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
