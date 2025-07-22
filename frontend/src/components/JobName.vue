<script>
export default {
  name: "JobName"
}
</script>

<template>
<div class="job-container">
  <div class="job-name">Fullstack-разработчик</div>
</div>
</template>

<style scoped>
.job-container {
  display: flex;
  justify-content: center;
  margin-bottom: 40px;
}
.job-name {
  padding: 5px 30px;
  background: #d0e7ff;
  border-radius: 20px;
  font-family: 'Open Sans', sans-serif;
  font-weight: 400;
  font-size: 25px;
  color: rgba(0, 0, 0, 0.85);
  line-height: 1.5;
  letter-spacing: 0.02em;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-shadow: 0 1px 1px rgba(0,0,0,0.1);
  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
}
@media (max-width: 600px) {
  .job-name {
    font-size: 22px;
  }
}
</style>