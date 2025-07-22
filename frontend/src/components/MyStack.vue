<script>
import SkillLine from "@/components/SkillLine.vue";
import springframework from "@/assets/spring-framework.svg"
import springSecurity from "@/assets/spring-security.svg"
import springData from "@/assets/spring-data.svg"
import springCloud from "@/assets/spring-cloud.svg"
import springBoot from "@/assets/spring-boot.svg"
import kafka from "@/assets/kafka.png"
import vue from "@/assets/vue.svg"
import keycloak from '@/assets/keycloak.svg'
import postgres from "@/assets/postgres.webp"



export default {
  name: "MyStack",
  components: {SkillLine},
  data() {
    return {
      springframework,
      springSecurity,
      postgres
    }
  }
}
</script>

<template>
  <div class="my-stack-container">
    <div>Технологии с которыми я работал:</div>
    <div class="my-stack-flex">
      <skill-line :src="springframework" text="spring framework"/>
      <skill-line :src="springSecurity" text="spring security"/>
      <skill-line :src="postgres" text="postgresql"/>
    </div>
  </div>
</template>

<style scoped>
.my-stack-container {
  padding: 20px;
  border-radius: 20px;
  background: #d0e7ff;
  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
  width: 100%;

}
.my-stack-flex {
  padding: 30px;
  display: flex;
  justify-content: left;
  flex-wrap: wrap;
  gap: 30px;
}
</style>