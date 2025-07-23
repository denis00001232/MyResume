<script>
export default {
  name: "SkillLine",
  props: {
    src: {
    },
    text: {
      type: String
    },
    interactive: {
      type: Boolean,
      default: false
    }
  },
  methods: {
    interactiveStyle() {
      if (this.interactive) {
        console.log("Прошло")
        return {
          animation: 'rotation 3s linear infinite'
        }
      } else {
        return {
        }
      }
    },
    interactiveStyle2() {
      if (this.interactive) {
        console.log("Прошло")
        return {
          animation: 'interactive 3s ease infinite'
        }
      } else {
        return {
        }
      }
    }
  }
}
</script>

<template>
  <div>
    <div class="skill-container" :style="interactiveStyle2()">
      <img v-if="src" :src="src" class="skill-image" alt="skill" :style="interactiveStyle()">
      <div class="skill-text">{{text}}</div>
    </div>
  </div>
</template>

<style scoped>
.skill-container {
  display: flex;
  width: fit-content;
  justify-content: left;
  align-items: center;
  gap: 15px;
  border-radius: 20px;
  padding: 10px;
  background: rgb(255, 255, 255);
  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
  overflow: clip;
  animation: appear 2s ease;
}
.skill-image {
  width: 40px;
  height: 40px;

}
.skill-text {
  font-family: 'Open Sans', sans-serif;
  font-weight: 400;
  font-size: 18px;
  color: rgba(0, 0, 0, 0.85);
  line-height: 1.5;
  letter-spacing: 0.02em;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-shadow: 0 1px 1px rgba(0,0,0,0.1);
}

@keyframes appear {
  0% {
    opacity: 0;
  }
  100% {
    opacity: 1;
  }
}

</style>
<style>
@keyframes rotation {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}

@keyframes interactive {
  0% {
    transform: translateY(0px);
  }
  25% {
    transform: translateY(-5px);
  }
  50% {
    transform: translateY(0px);
  }
  75% {
    transform: translateY(5px);
  }
  100% {
    transform: translateY(0px);
  }
}
</style>