<script>
export default {
  name: "SkillLine",
  props: {
    src: {
    },
    text: {
      type: String
    }
  }
}
</script>

<template>
  <div>
    <div class="skill-container">
      <img v-if="src" :src="src" class="skill-image" alt="skill">
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
</style>