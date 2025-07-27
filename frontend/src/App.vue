<script>
import BackgroundLines from "@/components/BackgroundLines.vue";
import MainPanel from "@/components/MainPanel.vue";
import {defineComponent} from "vue";
import axios from "axios";

export default defineComponent({
  components: {MainPanel, BackgroundLines},
  data() {
    return {
      disable: true
    }
  },
  methods: {
    sendInfo(action) {
      if (this.disable) {
        this.disable = false
        setTimeout(this.enable, 3000)
        console.log(action)
        axios.post(
            "api/observer/action",
            {}, // тело запроса
            {
              headers: {
                action: action // это заголовок "action"
              }
            }
        )
      }
    },
    enable() {
      this.disable = true
    }
  }
})


</script>

<template>
  <div @touchstart="sendInfo('mobile click')" @mousemove="sendInfo('mouse move')">
    <BackgroundLines/>
    <main-panel/>
  </div>
</template>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
</style>
