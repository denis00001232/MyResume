<script>
import Face from "@/components/Face.vue";
import JobName from "@/components/JobName.vue";
import Chat from "@/components/chat/Chat.vue";
import MyStack from "@/components/MyStack.vue";

export default {
  name: "MainPanel",
  components: {MyStack, Chat, JobName, Face}
}
</script>

<template>
  <div class="canvas">
    <div class="main-panel-container">
      <job-name/>
      <face/>
      <chat/>
      <my-stack/>
    </div>
  </div>
</template>

<style scoped>
.canvas {
  display: flex;
  justify-content: center;
}
.main-panel-container {
  margin-top: 30px;
  margin-bottom: 30px;
  padding: 30px;
  width: 860px;
  max-width: 860px;
  display: flex;
  flex-direction: column;
  background: #ffffff;
  border-radius: 30px;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.08);
}

@media (max-width: 900px) {
  .main-panel-container {
    width: 90%;
    max-width: 90%;
  }
}
</style>