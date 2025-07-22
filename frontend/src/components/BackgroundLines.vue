<script>
function getRandomInt(max) {
  return Math.floor(Math.random() * max);
}
export default {
  name: "BackgroundLines",
  data() {
    return {
      vertical1: false,
      horizontal1: false,
      vertical2: false,
      horizontal2: false,
      verticalX1: 13,
      horizontalY1: 2,
      verticalX2: 13,
      horizontalY2: 2
    }
  },
  mounted() {
    this.showVertical1()
    setTimeout(this.showVertical2, 2000)
  },
  methods: {
    showVertical1() {
      this.verticalX1 = getRandomInt(45)
      this.vertical1 = true
      setTimeout(this.hideVertical1, 2000)
    },
    hideVertical1() {
      this.vertical1 = false
      setTimeout(this.showHorizontal1, 2000)
    },
    showHorizontal1() {
      this.horizontalY1 = getRandomInt(45)
      this.horizontal1 = true
      setTimeout(this.hideHorizontal1, 2000)
    },
    hideHorizontal1() {
      this.horizontal1 = false
      setTimeout(this.showVertical1, 2000)
    },

    showVertical2() {
      this.verticalX2 = getRandomInt(45)
      this.vertical2 = true
      setTimeout(this.hideVertical2, 2000)
    },
    hideVertical2() {
      this.vertical2 = false
      setTimeout(this.showHorizontal2, 2000)
    },
    showHorizontal2() {
      this.horizontalY2 = getRandomInt(45)
      this.horizontal2 = true
      setTimeout(this.hideHorizontal2, 2000)
    },
    hideHorizontal2() {
      this.horizontal2 = false
      setTimeout(this.showVertical2, 2000)
    },



  },
  computed: {
    verticalStyle1() {
      return {
        marginLeft: `${this.verticalX1}%`
      }
    },
    horizontalStyle1() {
      return {
        marginTop: `${this.horizontalY1}%`
      }
    },
    verticalStyle2() {
      return {
        marginLeft: `${this.verticalX2}%`
      }
    },
    horizontalStyle2() {
      return {
        marginTop: `${this.horizontalY2}%`
      }
    }
  }
}
</script>

<template>
  <div class="main-panel-container">
    <div class="app-background"/>
    <div v-if="horizontal1" :style="horizontalStyle1" class="horizontal-line">
      <div class="before-line"/>
      <div class="color-line"/>
      <div class="after-line"/>
    </div>
    <div v-if="horizontal2" :style="horizontalStyle2" class="horizontal-line">
      <div class="after-line"/>
      <div class="color-line2"/>
      <div class="before-line"/>
    </div>
    <div v-if="vertical1" :style="verticalStyle1" class="vertical-line">
      <div class="vertical-line">
        <div class="before-line"/>
        <div class="color-line"/>
        <div class="after-line"/>
      </div>
    </div>
    <div v-if="vertical2" :style="verticalStyle2" class="vertical-line">
      <div class="vertical-line">
        <div class="after-line"/>
        <div class="color-line2"/>
        <div class="before-line"/>
      </div>
    </div>
  </div>
  <div class="main-panel-container">

  </div>
</template>

<style scoped>
.main-panel-container {
  position: fixed;
  width: 100%;
  height: 100%;
  z-index: -1;
}
.vertical-line {
  width: 10px;
  height: 100%;
  display: flex;
  flex-direction: column;
}
.horizontal-line {
  display: flex;
  flex-direction: row;
}
.before-line {
  animation: before-line 2s ease infinite;
}

.after-line {
  animation: after-line 2s ease infinite;
}

.color-line {
  background: rgba(239, 86, 86, 0.3);
  animation: color-line 2s ease infinite;
  box-shadow: 0 0 20px 20px rgba(239, 86, 86, 0.3) /* X=0, Y=0 → вокруг объекта */
}

.color-line2 {
  background: rgba(86, 239, 226, 0.3);
  animation: color-line2 2s ease infinite;
  box-shadow: 0 0 20px 20px rgba(86, 239, 226, 0.3) /* X=0, Y=0 → вокруг объекта */
}

.app-background {
  background: linear-gradient(-45deg, #e5fbff, #ffe5e5);
  position: fixed;
  width: 100%;
  height: 100%;
  z-index: -3;
}

@keyframes back-ground {

}

@keyframes before-line {
  0% {
    flex-basis: 100%;
  }
  50% {
    flex-basis: 0;
  }
  100% {
    flex-basis: 0;
  }
}

@keyframes color-line {
  0% {
    flex-basis: 0;
    border-radius: 10px;
    box-shadow: 0 0 0 0 rgba(239, 86, 86, 0.3) /* X=0, Y=0 → вокруг объекта */
  }
  50% {
    flex-basis: 100%;
    border-radius: 20px;
    box-shadow: 0 0 20px 20px rgba(239, 86, 86, 0.3) /* X=0, Y=0 → вокруг объекта */

  }
  100% {
    flex-basis: 0;
    border-radius: 10px;
    box-shadow: 0 0 0 0 rgba(239, 86, 86, 0.3) /* X=0, Y=0 → вокруг объекта */
  }
}

@keyframes color-line2 {
  0% {
    flex-basis: 0;
    border-radius: 10px;
    box-shadow: 0 0 0 0 rgba(86, 239, 226, 0.3) /* X=0, Y=0 → вокруг объекта */
  }
  50% {
    flex-basis: 100%;
    border-radius: 20px;
    box-shadow: 0 0 20px 20px rgba(86, 239, 234, 0.3) /* X=0, Y=0 → вокруг объекта */

  }
  100% {
    flex-basis: 0;
    border-radius: 10px;
    box-shadow: 0 0 0 0 rgba(86, 239, 234, 0.3) /* X=0, Y=0 → вокруг объекта */
  }
}

@keyframes after-line {
  0% {
    flex-basis: 0;
  }
  50% {
    flex-basis: 0;
  }
  100% {
    flex-basis: 100%;
  }
}
</style>