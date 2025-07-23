<script>
import Face from "@/components/Face.vue";
import JobName from "@/components/JobName.vue";
import Chat from "@/components/chat/Chat.vue";
import MyStack from "@/components/MyStack.vue";
import Links from "@/components/Links.vue";

export default {
  name: "MainPanel",
  components: {Links, MyStack, Chat, JobName, Face}
}
</script>

<template>
  <div class="canvas">
    <div class="main-panel-container">
      <job-name/>
      <face/>
      <chat/>
      <my-stack/>
      <links/>
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

@media (max-width: 600px) {
  .main-panel-container {
    width: 98%;
    background: rgba(208, 231, 255, 0);
    padding: 40px 0;
    box-shadow: none;
  }
}
</style>