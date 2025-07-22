<script>
function getRandomInt(max) {
  return Math.floor(Math.random() * max);
}
let timeSpan = 3000
export default {
  name: "BeautifulBackground",
  data() {
    return {
      cubeRedPos: {
        x: 10,
        y: 5
      },
      cubeGreenPos: {
        x: 1,
        y: 9
      },
      cubeYellowPos: {
        x: 14,
        y: 50
      },
      cubes: [
        {
          name: "redCube"
        }
      ]
    }
  },

  computed: {
    cubeRedStyle() {
      return {
        transform: `translate(${this.cubeRedPos.x}vw, ${this.cubeRedPos.y}vh)`,
        transition: 'transform 3s ease-in-out'
      }
    },
    cubeGreenStyle() {
      return {
        transform: `translate(${this.cubeGreenPos.x}vw, ${this.cubeGreenPos.y}vh)`,
        transition: 'transform 3s ease-in-out'
      }
    },
    cubeYellowStyle() {
      return {
        transform: `translate(${this.cubeYellowPos.x}vw, ${this.cubeYellowPos.y}vh)`,
        transition: 'transform 3s ease-in-out'
      }
    }
  },

  methods: {
    moveRedCube() {
      this.cubeRedPos = this.randomCords()
      setTimeout(this.moveGreenCube, timeSpan)
    },
    moveGreenCube() {
      this.cubeGreenPos = this.randomCords()
      setTimeout(this.moveYellowCube, timeSpan)

    },
    moveYellowCube() {
      this.cubeYellowPos = this.randomCords()
      setTimeout(this.moveRedCube, timeSpan)
    },

    randomCords() {
      return {
        x: getRandomInt(100),
        y: getRandomInt(100)
      }
    }
  },
  mounted() {
    this.moveRedCube()
  }
}
</script>

<template>
  <div class="main-panel-container">
    <div class="redCube" :style="cubeRedStyle"></div>
    <div class="greenCube" :style="cubeGreenStyle"></div>
    <div class="yellowCube" :style="cubeYellowStyle"></div>
  </div>
</template>

<style scoped>
.main-panel-container {
  position: fixed;
  width: 100%;
  height: 100%;
  z-index: -1;
  background: rgba(255, 188, 188, 0.16);
}
.redCube {
  width: 60px;
  height: 60px;
  background: rgba(255, 61, 61, 0.65);
  border-radius: 20px;
}
.greenCube {
  width: 60px;
  height: 60px;
  background: rgba(44, 152, 44, 0.5);
  border-radius: 20px;
}
.yellowCube {
  width: 60px;
  height: 60px;
  background: rgba(152, 152, 62, 0.5);
  border-radius: 20px;
}
</style>