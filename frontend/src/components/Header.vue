<script>
export default {
  name: "Header"
}
</script>

<template>
<div class="background">
  <div class="text-container">
    <div class="text">Денис Савченко</div>
  </div>
  <div class="text-container">
    <div class="text">Full Stack разработчик уже 1.5 года</div>
  </div>
  <div>

  </div>
</div>
</template>

<style scoped>
.background {
  display: flex;
  align-items: center;
  flex-wrap: wrap;
  padding: 5vh 5vw;
  gap: 5vw;
}
.text {
  font-size: 20px;
  color: aliceblue;
}
.text-container {
  padding: 10px 5px;
  background: cadetblue;
  border-radius: 10px;
}
</style>