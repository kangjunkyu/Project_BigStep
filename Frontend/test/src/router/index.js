import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import BeforeLoginView from "@/views/BeforeLoginView.vue";
import LoginView from "@/views/LoginView.vue";
import SignUpView from "@/views/SignUpView.vue";
import AfterLoginView from "@/views/AfterLoginView.vue";
import DiaryView from "@/views/DiaryView.vue";
import FollowView from "@/views/FollowView.vue";
import MyPageView from "@/views/MyPageView.vue";
import SearchView from "@/views/SearchView.vue";
import DiaryList from "@/components/diary/DiaryList.vue";
import DiaryDetail from "@/components/diary/DiaryDetail.vue";
import DiaryWrite from "@/components/diary/DiaryWrite.vue";
import DiaryWriteWithDate from '@/components/diary/DiaryWriteWithDate.vue'
import DiaryUpdate from "@/components/diary/DiaryUpdate.vue";
import SearchResult from "@/components/search/SearchResult.vue";
import followerList from "@/components/follow/followerList.vue";
import followingList from "@/components/follow/followingList.vue";
import TodoDetail from "@/components/todo/TodoDetail.vue";
import TodoList from "@/components/todo/TodoList.vue";
import TodoCreate from "@/components/todo/TodoCreate.vue";
import TodoUpdate from "@/components/todo/TodoUpdate.vue";
import NaverLoginView from "@/views/NaverLoginView.vue";
import UserPageMain from "@/components/user/UserPageMain.vue";
import UserUpdate from "@/components/user/UserUpdate.vue";
import UserNaverUpdate from "@/components/user/UserNaverUpdate.vue";
import EventView from "@/views/EventView.vue";
import Event from "@/components/common/Event.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "beforelogin",
      component: BeforeLoginView,
      children: [
        {
          path: "",
          name: "home",
          component: HomeView,
        },
        {
          path: "/login",
          name: "login",
          component: LoginView,
        },
        {
          path: "/naverlogin",
          name: "naverlogin",
          component: NaverLoginView,
        },
        {
          path: "/signup",
          name: "signup",
          component: SignUpView,
        },
      ],
    },
    {
      path: "/main",
      name: "main",
      component: AfterLoginView,
      children: [
        {
          path: "/diary",
          name: "diary",
          component: DiaryView,
          children: [
            {
              path: "list",
              name: "diaryList",
              component: DiaryList,
            },
            {
              path: "detail/:diaryId",
              name: "diaryDetail",
              component: DiaryDetail,
              children: [
                {
                  path: "",
                  name: "todolist",
                  component: TodoList,
                },
                {
                  path: "todo/detail/:todoId",
                  name: "tododetail",
                  component: TodoDetail,
                },
                {
                  path: "todo/create",
                  name: "todocreate",
                  component: TodoCreate,
                },
                {
                  path: "todo/update/:todoId",
                  name: "todoupdate",
                  component: TodoUpdate,
                },
              ],
            },
            {
              path: "write",
              name: "diaryWrite",
              component: DiaryWrite,
            },
            {
              path:"write/:year/:month/:day",
              name: "diaryWriteWithDate",
              component: DiaryWriteWithDate,
            },
            {
              path: "update/:diaryId",
              name: "diaryUpdate",
              component: DiaryUpdate,
            },
            {
              path: "todo/detail",
              name: "todoDetail",
              component: TodoDetail,
            },
          ],
        },
        {
          path: "/follow",
          name: "follow",
          component: FollowView,
        },
        {
          path: "/my-page",
          name: "mypage",
          component: MyPageView,
          children: [
            {
              path: "",
              name: "userpagemain",
              component: UserPageMain,
            },
            {
              path: "update",
              name: "userupdate",
              component: UserUpdate,
            },
            {
              path: "/naverupdate",
              name: "naverupdate",
              component: UserNaverUpdate,
            },
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
          ],
        },
        {
          path: "/search",
          name: "search",
          component: SearchView,
          children: [
            {
              path: "result",
              name: "searchResult",
              component: SearchResult,
            },
          ],
        },
        {
          path: "/Event",
          name: "Event",
          component: EventView,
          children: [
            {
              path: "Eventresult",
              name: "EventResult",
              component: Event,
            },
          ],
        },
      ],
    },
  ],
});

export default router;
