import Vue from "vue";
import App from "./App.vue";
import axios from "axios";

Vue.prototype.$http = axios;

Vue.config.productionTip = false;

new Vue({
  render: (h) => h(App),
}).$mount("#app");
const API_KEY = "b975d71d5c63adc9e2d0f09f598d5bef";
