<template>
  <button type="button" @click="searchWeather" :disabled="view || loading">
    오늘은 이 운동 어떠세요?!?!
  </button>
  <div class="TotalEvent">
    <div id="wrapCard">
      <div class="card">
        <div class="card_front">
          <div v-if="view">
            <!-- <p style="font-size: 30px">국가명: {{ country }}</p> -->
            <p style="font-size: 30px">도시명: {{ city }}</p>
            <br />
            <p style="font-size: 20px">온도: {{ temp }}</p>
            <p style="font-size: 20px">현재날씨 : {{ weather }}</p>
            <!-- <p>최저온도 : {{ temp_min }}</p>
    <p>최대온도 : {{ temp_max }}</p> -->
          </div>
          <div v-if="loading">로딩 중...</div>
          <div v-if="error">{{ error }}</div>
        </div>
        <div class="card_back">
          <p style="font-size: 30px">현재 온도에 맞는 운동을 추천해드려요</p>
          <p style="font-size: 30px">야외운동</p>
          <p style="font-size: 30px">런닝</p>
        </div>
      </div>
    </div>
    <div style="width: 300px; text-align: center">dododododo</div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "app",
  data() {
    return {
      view: false,
      country: "",
      city: "",
      loading: false,
      error: null,
      weather: null,
      temp: null,
      min_temp: null,
      max_temp: null,
    };
  },
  methods: {
    searchWeather() {
      const BASE_URL =
        "http://api.openweathermap.org/data/2.5/weather?q=Daejeon&appid=b975d71d5c63adc9e2d0f09f598d5bef";

      this.loading = true;
      this.error = null;

      axios
        .get(BASE_URL)
        .then((result) => {
          this.country = result.data.sys.country;
          this.city = result.data.name;
          this.view = true;
          this.weather = result.data.weather[0].description;
          this.temp = Math.ceil(result.data.main.temp - 273.15);
          this.temp_min = Math.ceil(result.data.main.temp_min - 273.15);
          this.temp_max = Math.ceil(result.data.main.temp_max - 273.15);
          console.log(result);
        })
        .catch((error) => {
          this.error =
            "날씨 정보를 가져오는 중 오류가 발생했습니다. 나중에 다시 시도해주세요.";
          console.error("날씨 데이터를 가져오는 중 오류 발생:", error);
        })
        .finally(() => {
          this.loading = false;
        });
    },
  },
};
</script>

<style>
.TotalEvent {
  width: 600px;
  display: flex;
  justify-content: space-between;
}
.card_front {
  display: flex;
  flex-direction: column;
  text-align: center;
  justify-content: center;
  /* width: 300px;
  height: 500px; */

  background-image: url("../../assets/abstract_hand_painted_sunset_clouds_background_2606.jpg");
  background-size: cover;
  transform: rotateY(0deg);
  transition: 2s;
}
.card_front:hover {
  /* transform: perspective(1000px) rotateY(180deg); */
}

.card_back {
  /* justify-content: center;
  width: 300px;
  height: 500px; */
  display: flex;
  flex-direction: column;
  text-align: center;
  justify-content: center;
  background-color: grey;
  background: linear-gradient(#e66465, #9198e5);
  transform: rotateY(180deg);
  transition: 2s;
  color: black;
}

#wrapCard {
  /* display: inline-grid;
  text-align: center;
  color: gray;
  transition: transform 0.3s;
  transform: perspective(800px) rotateY(0deg);
  transform-style: preserve-3d;
  border-radius: 50px; */

  position: relative;
  width: 300px;
  height: 500px;
  margin: 50px auto;
  border-radius: 20px;
  perspective: 1000px;
  cursor: pointer;
  /* overflow: hidden; */
  /* overflow-y: hidden; */
}

#wrapCard .card {
  width: 100%;
  height: 100%;
  transition: all 0.5s;
  transform-style: preserve-3d;
  transform-origin: center bottom;
}

#wrapCard:hover .card {
  transform: rotateY(180deg);
}

#wrapCard .card > div {
  position: absolute;
  top: 0;
  left: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  font-size: 20px;
  border-radius: 20px;
  backface-visibility: hidden;
}

#wrapCard .card .card-front {
  background-color: #f54;
  z-index: 10;
  transform-origin: center bottom;
}

#wrapCard .card .card-back {
  background-color: #ccc;
  z-index: 5;
  transform: rotateY(180deg);
  transform-origin: center bottom;
}

/* .wrapCard:hover {
  transform: perspective(800px) rotateY(180deg);
}
.wrapCard > * {
  grid-area: 1 / 1 / 1 / 1;
  width: 300px;
  height: 500px;
  padding: 12px;
  border-radius: 8px;
  backface-visibility: hidden;
} */
</style>
