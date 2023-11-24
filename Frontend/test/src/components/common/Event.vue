<template>
  <br />
  <!-- <div @click="">운동 변경</div> -->
  <div class="TotalEvent" style="font-family: 'Noto Sans KR', sans-serif">
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
          <div class="view111">
            <div
              style="
                width: 100px;
                height: 70px;
                text-align: center;
                margin: 0 auto;
              "
            >
              <img
                src="@/assets/cursor2.png"
                alt=""
                style="width: 70px; height: 70px; text-align: center"
              />
            </div>
            <div>
              <br />
              <p v-if="view1" class="p1">마우스를 올려보세요</p>
              <p v-if="view2" class="p1">운동 추천과 동기부여</p>
              <p v-if="view3" class="p1">오늘도 힘내는 당신 화이팅</p>
            </div>
          </div>

          <div v-if="loading">로딩 중...</div>
          <div v-if="error">{{ error }}</div>
        </div>
        <div class="card_back" v-show="view">
          <div v-if="temp > 28">
            <p style="font-size: 30px">너무 더워요</p>
            <p style="font-size: 30px">일사병 조심</p>
            <p style="font-size: 30px">실내운동</p>
            <br />
            <p style="font-size: 30px">{{ insideWorkout[RandomInside] }}</p>
            <br />
            <p style="font-size: 20px">오늘의 동기부여 한마디</p>
            <p style="font-size: 15px">{{ motivation[RandomMotivation] }}</p>
          </div>
          <div v-else-if="temp > 16 && temp <= 28">
            <p style="font-size: 30px">나가기 좋은 날씨에요</p>
            <p style="font-size: 30px">가벼운 발걸음으로</p>
            <p style="font-size: 30px">야외운동</p>
            <br />
            <p style="font-size: 30px">
              {{ outsideWorkout[RandomOutside] }}
            </p>
            <br />
            <p style="font-size: 20px">오늘의 동기부여 한마디</p>
            <p style="font-size: 15px">{{ motivation[RandomMotivation] }}</p>
          </div>
          <div v-else-if="temp <= 16 && temp > 10">
            <p style="font-size: 30px">시원하게 밖으로!</p>
            <p style="font-size: 30px">야외운동</p>
            <br />
            <p style="font-size: 30px">
              {{ outsideWorkout[RandomOutside] }}
            </p>
            <br />
            <p style="font-size: 20px">오늘의 동기부여 한마디</p>
            <p style="font-size: 15px">{{ motivation[RandomMotivation] }}</p>
          </div>
          <div v-else-if="weather === 'Rain'">
            <p style="font-size: 30px">비와요!! 실내운동!!</p>
            <p style="font-size: 30px">실내운동</p>
            <br />
            <p style="font-size: 30px">{{ insideWorkout[RandomInside] }}</p>
            <br />
            <p style="font-size: 20px">오늘의 동기부여 한마디</p>
            <p style="font-size: 15px">{{ motivation[RandomMotivation] }}</p>
          </div>
          <div v-else-if="weather === 'Snows'">
            <p style="font-size: 30px">밖에 눈이 와요</p>
            <p style="font-size: 30px">실내운동</p>
            <br />
            <p style="font-size: 30px">{{ insideWorkout[RandomInside] }}</p>
            <br />
            <p style="font-size: 15px">{{ motivation[RandomMotivation] }}</p>
          </div>
          <div v-else="temp <= 10">
            <p style="font-size: 30px">밖이 너무 추워요..</p>
            <p style="font-size: 30px">실내운동 어때요?</p>
            <p style="font-size: 30px">실내운동</p>
            <br />
            <p style="font-size: 30px">{{ insideWorkout[RandomInside] }}</p>
            <br />
            <p style="font-size: 20px">오늘의 동기부여 한마디</p>
            <p style="font-size: 15px">{{ motivation[RandomMotivation] }}</p>
          </div>
        </div>
      </div>
    </div>
    <div
      v-if="weather === 'Clear'"
      class="information"
      v-show="view"
      style="width: 300px; text-align: center; padding: 30px"
    >
      <div v-show="view">
        <div>
          <p class="text-2xl">도시명: {{ city }}</p>
          <img src="@/assets/sun.png" style="width: 200px" />
          <br />
          <p>온도: {{ temp }}</p>
          <p>체감온도 : {{ feels_like }}</p>
          <p>현재날씨 : {{ weather }}</p>
          <p>습도 : {{ humidity }}</p>
        </div>
      </div>
    </div>
    <div
      v-else-if="weather === 'Clouds'"
      class="information"
      v-show="view"
      style="width: 300px; text-align: center; padding: 30px"
    >
      <div v-show="view">
        <div>
          <p>도시명: {{ city }}</p>
          <img src="@/assets/clouds.png" style="width: 200px" />
          <br />
          <p>온도: {{ temp }}</p>
          <p>체감온도 : {{ feels_like }}</p>
          <p>현재날씨 : {{ weather }}</p>
          <p>습도 : {{ humidity }}</p>
        </div>
      </div>
    </div>
    <div
      v-else-if="weather === 'Rain'"
      class="information"
      v-show="view"
      style="width: 300px; text-align: center; padding: 30px"
    >
      <div v-show="view">
        <div>
          <p>도시명: {{ city }}</p>
          <img src="@/assets/rains.png" style="width: 200px" />
          <br />
          <p>온도: {{ temp }}</p>
          <p>체감온도 : {{ feels_like }}</p>
          <p>현재날씨 : {{ weather }}</p>
          <p>습도 : {{ humidity }}</p>
        </div>
      </div>
    </div>
    <div
      v-else-if="weather === 'Snows'"
      class="information"
      v-show="view"
      style="width: 300px; text-align: center; padding: 30px"
    >
      <div v-show="view">
        <div>
          <p class="text-lg">도시명: {{ city }}</p>
          <img src="@/assets/snows.png" style="width: 200px" />
          <br />
          <p>온도: {{ temp }}</p>
          <p>체감온도 : {{ feels_like }}</p>
          <p>현재날씨 : {{ weather }}</p>
          <p>습도 : {{ humidity }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";

const motivation = ref([
  "우리가 반복적으로 하는 것이 우리 자신을 만든다.",
  "운동은 사람의 몸과 감적과 정신력의 창조적 변화를 위한 약이다.",
  "독서는 마음을 위한 것이고, 운동은 몸을 위한 것이다.",
  "운동이 끝나고 먹는 거까지가 운동이다.",
  "당신이 하고 싶은 것을 할 수 있을 때까지, 당신이 해야 할 일을 해라.",
  "그만두고 싶다는 생이각이 들면, 왜 시작했는지 생각해보라.",
  "물을 끓이는 건 마지막 1도, 포기하고 싶은 바로 그 1분을 참아내는 것.",
  "남들이 그만둘 때, 난 계속한다.",
  "간단해요, 흔들리면 그건 지방이에요.",
  "무슨 일이 있어도 2개 더해.",
  "계획보다 행동으로",
  "모든 변화의 시작은 행복이다.",
]);

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
const RandomMotivation = ref(null);

const view = ref(false);
const view1 = ref(false);
const view2 = ref(false);
const view3 = ref(false);
const country = ref("");
const city = ref("");
const loading = ref(false);
const error = ref(null);
const weather = ref(null);
const temp = ref(null);
const feels_like = ref(null);
const humidity = ref(null);
// const iconcode = ref(null);
// const iconurl = ref(null);
// const iconElement = ref(null);

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
    // iconcode.value = result.data.weather[0].icon;
    // iconurl.value = `http://openweathermap.org/img/wn/${iconcode}@2x.png`;

    // weatherIconImg.setAttribute("src", weatherIconAdrs);

    // iconElement = document.getElementById("myImage");
    // iconElement.src = iconurl;

    console.log(result);
  } catch (error) {
    error.value =
      "날씨 정보를 가져오는 중 오류가 발생했습니다. 나중에 다시 시도해주세요.";
    console.error("날씨 데이터를 가져오는 중 오류 발생:", error);
  } finally {
    loading.value = false;
  }
};

// const iconurl = "http://openweathermap.org/img/w/" + iconcode + ".png";
// $("#wicon").attr("src", iconurl);

const selectOutside = () => {
  const randomIndex = Math.floor(Math.random() * outsideWorkout.value.length);
  RandomOutside.value = randomIndex;
  console.log(randomIndex);
};

const selectInside = () => {
  const randomIndex = Math.floor(Math.random() * insideWorkout.value.length);
  RandomInside.value = randomIndex;
  console.log(randomIndex);
};

const selectMotivation = () => {
  const randomIndex = Math.floor(Math.random() * motivation.value.length);
  RandomMotivation.value = randomIndex;
  console.log(randomIndex);
};

// const weatherClass = ref({
//   class1_1: weather.value === "Snows",
//   class1_2: weather.value === "Clouds",
//   class1_3: weather.value === "Clear",
//   class1_4: weather.value === "Rain",
// });

onMounted(() => {
  searchWeather();
  selectInside();
  selectOutside();
  selectMotivation();
  // console.log(outsideWorkout.value.length);
  // setTimeout(() => (view0.value = true), 1000);
  setTimeout(() => (view1.value = true), 700);
  setTimeout(() => (view2.value = true), 1400);
  setTimeout(() => (view3.value = true), 2400);
});
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&family=Noto+Sans+KR:wght@500&display=swap");

.information {
  margin: 50px;
  display: flex;
  text-align: center;
  justify-content: center;
  /* justify-content: space-between; */
  align-items: center;
  /* align-content: center; */
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
.view111 {
  height: 270px;
  align-items: center;
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

@keyframes fadein {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

.p1 {
  animation: fadein 0.5s ease;
}
</style>
