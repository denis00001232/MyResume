<script>
import SkillLine from "@/components/SkillLine.vue";
import face from '@/assets/me.png'

export default {
  name: "Face",
  components: {SkillLine},
  data() {
    return {
      face
    }
  }
}
</script>

<template>
  <div class="face-container">
    <div class="face-image-container">
      <img class="face-image" :src="face" alt="Me"/>
    </div>
    <div class="info-container">
      <div class="face-text-container">
        Привет, меня зовут Денис — fullstack-developer с упором на backend, свой путь разработчика я начал еще в 21 году
        когда впервые открыл Head First java, а сейчас я уже способен разрабатывать достаточно крупные и сложные веб-приложения
        под любые задачи бизнеса.
      </div>
    </div>
  </div>
</template>

<style scoped>
.face-container {
  display: flex;
  flex-direction: row-reverse;
  flex-wrap: wrap;
}

.face-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.face-image-container {
  overflow: clip;
  border-radius: 50%;
  flex-basis: 50%;
  aspect-ratio: 1/1;
  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
  transition: all 0.3s ease;
}

.face-image-container:hover {
  transform: translateY(-5px);
  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.48);
}

.info-container {
  padding: 10px 10px 10px 10px;
  flex-basis: 50%;
}
.face-text-container {
  transform-style: preserve-3d;
  height: 100%;
  margin-right: 30px;
  border-radius: 20px;
  padding: 10px;
  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
  font-family: 'Open Sans', sans-serif;
  font-weight: 400;
  font-size: 20px;
  color: rgba(0, 0, 0, 0.85);
  line-height: 1.5;
  letter-spacing: 0.01em;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-shadow: 0 1px 1px rgba(0,0,0,0.1);
  animation: card-rotation 1s ease;
}

@keyframes card-rotation {
  0% {
    transform: rotateY(180deg);
    color: rgba(0, 0, 0, 0);
    text-shadow: 0 1px 1px rgba(0, 0, 0, 0);
  }
  50% {
    transform: rotateY(90deg);
    color: rgba(0, 0, 0, 0);
    text-shadow: 0 1px 1px rgba(0, 0, 0, 0);
  }
  100% {
    transform: rotateY(0deg);
    color: rgba(0, 0, 0, 0.85);
    text-shadow: 0 1px 1px rgba(0,0,0,0.1);
  }
}

@media (max-width: 900px) {
  .face-container {
    display: flex;
    gap: 40px;
    flex-direction: column;
    flex-wrap: nowrap;
    align-items: center;
  }

  .face-image-container {
    overflow: clip;
    border-radius: 50%;
    width: 400px;
    height: 400px;
    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
    transition: all 0.3s ease;
  }

  .face-text-container {
    width: 100%;
    margin-right: 0;
  }

  .info-container {
    padding: 0;
  }

}
@media (max-width: 550px) {
  .face-container {
    display: flex;
    flex-direction: column;
    gap: 40px;
    flex-wrap: nowrap;
    align-items: center;
  }

  .face-image-container {
    overflow: clip;
    border-radius: 50%;
    flex-basis: 50%;
    width: 280px;
    height: 280px;
    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
    transition: all 0.3s ease;
  }

  .face-text-container {
    width: 100%;
    margin-right: 0;

  }
  .info-container {
    padding: 0;
  }

}

@media (max-width: 600px) {
  .face-text-container {
    background: rgba(255, 254, 254, 0.69);

  }
}
</style>