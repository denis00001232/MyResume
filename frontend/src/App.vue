<script>
import BackgroundLines from "@/components/BackgroundLines.vue";
import MainPanel from "@/components/MainPanel.vue";
import {defineComponent} from "vue";

export default defineComponent({
  components: {MainPanel, BackgroundLines}
})


</script>

<template>
  <BackgroundLines/>
  <main-panel/>
</template>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
</style>
