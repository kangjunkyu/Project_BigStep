<template>
  <br />
  <!-- <div @click="">운동 변경</div> -->
  <div class="TotalEvent">
    <div id="wrapCard">
      <div class="card">
        <!-- <div class="card_front"> -->
        <div
          :class="{
            class1_1: weather == 'Snows',
            class1_2: weather == 'Clouds',
            class1_3: weather == 'Clear',
            class1_4: weather == 'Rain',
          }"
        >
          <div v-if="view">
            <p>마우스를 올려보세요</p>
            <p>운동을 추천해드릴게요!</p>
            <p>오늘도 힘차게 달려볼까요!</p>
          </div>
          <div v-else-if="!view">
            위에 이미지를 클릭하면 운동을 추천해드려요!
          </div>
          <div v-if="loading">로딩 중...</div>
          <div v-if="error">{{ error }}</div>
        </div>
        <div class="card_back" v-show="view">
          <div v-if="temp > 25">
            <p style="font-size: 30px">너무 더워요</p>
            <p style="font-size: 30px">실내운동</p>
            <br />
            <p style="font-size: 30px">{{ RandomInside }}</p>
          </div>
          <div v-else-if="temp > 16 && temp <= 25">
            <p style="font-size: 30px">나가기 좋은 날씨에요</p>
            <p style="font-size: 30px">야외운동</p>
            <br />
            <p style="font-size: 30px">{{ RandomOutside }}</p>
          </div>
          <div v-else-if="temp <= 16 && temp > 10">
            <p style="font-size: 30px">시원하게 밖으로!</p>
            <p style="font-size: 30px">야외운동</p>
            <br />
            <p style="font-size: 30px">{{ RandomOutside }}</p>
          </div>
          <div v-else-if="weather === 'Rain'">
            <p style="font-size: 30px">비와요!! 실내운동!!</p>
            <p style="font-size: 30px">실내운동</p>
            <br />
            <p style="font-size: 30px">{{ RandomInside }}</p>
          </div>
          <div v-else-if="weather === 'Snows'">
            <p style="font-size: 30px">밖에 눈이 와요</p>
            <p style="font-size: 30px">실내운동</p>
            <br />
            <p style="font-size: 30px">{{ RandomInside }}</p>
          </div>
          <div v-else="temp <= 10">
            <p style="font-size: 30px">밖은 추우니 실내운동 어때요?</p>
            <p style="font-size: 30px">실내운동</p>
            <br />
            <p style="font-size: 30px">{{ RandomInside }}</p>
          </div>
        </div>
        <!-- <div
          :class="{
            class1_1: weather === 'Clouds',
            class1_2: weather === 'Snow',
            class1_3: weather === 'Rain',
          }"
        ></div> -->
      </div>
    </div>
    <div
      class="information"
      v-show="view"
      style="width: 300px; text-align: center; padding: 30px"
    >
      <div v-show="view">
        <div>
          <p style="font-size: 30px">도시명: {{ city }}</p>
          <br />
          <p style="font-size: 20px">온도: {{ temp }}</p>
          <p>체감온도 : {{ feels_like }}</p>
          <p style="font-size: 20px">현재날씨 : {{ weather }}</p>
          <p>습도 : {{ humidity }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";

const outsideWorkout = ref([
  "축구",
  "홈트",
  "경보",
  "런닝",
  "줄넘기",
  "풋살",
  "등산",
]);
const insideWorkout = ref([
  "헬스",
  "볼링",
  "숨쉬기운동",
  "당구",
  "탁구",
  "수영",
  "클라이밍",
]);

const RandomOutside = ref(null);
const RandomInside = ref(null);

const view = ref(false);
const country = ref("");
const city = ref("");
const loading = ref(false);
const error = ref(null);
const weather = ref(null);
const temp = ref(null);
const feels_like = ref(null);
const humidity = ref(null);

const searchWeather = async () => {
  const BASE_URL =
    "http://api.openweathermap.org/data/2.5/weather?q=Daejeon&appid=b975d71d5c63adc9e2d0f09f598d5bef";

  loading.value = true;
  error.value = null;

  try {
    const result = await axios.get(BASE_URL);
    country.value = result.data.sys.country;
    city.value = result.data.name;
    view.value = true;
    weather.value = result.data.weather[0].main;
    temp.value = Math.ceil(result.data.main.temp - 273.15);
    feels_like.value = Math.ceil(result.data.main.feels_like - 273.15);
    humidity.value = result.data.main.humidity;
    console.log(result);
  } catch (error) {
    error.value =
      "날씨 정보를 가져오는 중 오류가 발생했습니다. 나중에 다시 시도해주세요.";
    console.error("날씨 데이터를 가져오는 중 오류 발생:", error);
  } finally {
    loading.value = false;
  }
};

const selectOutside = () => {
  const randomIndex = Math.floor(Math.random() * outsideWorkout.value.length);
  RandomOutside.value = outsideWorkout[randomIndex];
  console
};

const selectInside = () => {
  const randomIndex = Math.floor(Math.random() * insideWorkout.value.length);
  RandomInside.value = insideWorkout[randomIndex];
};

// const weatherClass = ref({
//   class1_1: weather.value === "Snows",
//   class1_2: weather.value === "Clouds",
//   class1_3: weather.value === "Clear",
//   class1_4: weather.value === "Rain",
// });

onMounted(()=>{
  searchWeather();
  selectInside();
  selectOutside();
})
</script>

<style>
.information {
  margin: 50px;
  display: flex;
  text-align: center;
  /* justify-content: center; */
  justify-content: space-between;
  align-items: center;
}
.class1_1 {
  display: flex;
  flex-direction: column;
  text-align: center;
  justify-content: center;

  background-image: url("../../assets/snow.jpg");
  background-size: cover;
  transform: rotateY(0deg);
  transition: 2s;
}
.class1_2 {
  display: flex;
  flex-direction: column;
  text-align: center;
  justify-content: center;

  background-image: url("../../assets/cloud.jpeg");
  background-size: cover;
  transform: rotateY(0deg);
  transition: 2s;
}
.class1_3 {
  display: flex;
  flex-direction: column;
  text-align: center;
  justify-content: center;

  background-image: url("../../assets/clear.jpg");
  background-size: cover;
  transform: rotateY(0deg);
  transition: 2s;
}
.class1_4 {
  display: flex;
  flex-direction: column;
  text-align: center;
  justify-content: center;

  background-image: url("../../assets/rain.jpeg");
  background-size: cover;
  transform: rotateY(0deg);
  transition: 2s;
}
.TotalEvent {
  width: 800px;
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

  background-image: url("../../assets/clear.jpg");
  background-size: cover;
  transform: rotateY(0deg);
  transition: 2s;
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

p {
  padding-bottom: 20px;
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
