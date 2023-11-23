import { createApp } from "vue";
import { createPinia } from "pinia";
import piniaPluginPersistedState from "pinia-plugin-persistedstate";
import "tailwindcss/tailwind.css";
import VCalendar from 'v-calendar'
import "v-calendar/style.css"

import App from "./App.vue";
import router from "./router";

const app = createApp(App);
const pinia = createPinia();

pinia.use(piniaPluginPersistedState);

app.use(pinia);
app.use(router);
app.use(VCalendar,{})

app.mount("#app");
