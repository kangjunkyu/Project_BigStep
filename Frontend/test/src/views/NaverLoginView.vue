<template>
  <div>
    <p>Naver Login Access Pages</p>
  </div>
</template>

<script>
import router from "@/router";
import { useUserStore } from "@/stores/user";

export default {
  mounted() {
    const userStore = useUserStore();
    const naver_id_login = new window.naver_id_login(
      "VuKdfgG2Qc1tgI8UjxPb",
      "http://localhost:5173/naverlogin"
    );
    const accessToken = naver_id_login.getAccessToken();

    userStore.checkToken(accessToken);

    // window.self.close()
    router.push("/");
  },
};
</script>

<style scoped></style>
