<template>
  <div>
    <div id="naver_id_login"></div>
  </div>
</template>

<script>
export default {
  mounted() {
    const naver_id_login = new window.naver_id_login(
      "VuKdfgG2Qc1tgI8UjxPb",
      "http://localhost:5173/naverlogin"
    );
    const state = naver_id_login.getUniqState();
    naver_id_login.setButton("green", 3, 40);
    naver_id_login.setState(state);
    // naver_id_login.setPopup();
    naver_id_login.init_naver_id_login();
  },
};
</script>

<style scoped></style>
