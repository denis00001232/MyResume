<script>
import SkillLine from "@/components/SkillLine.vue";
import java from "@/assets/java.png"
import kotlin from "@/assets/kotlin.png"
import godot from "@/assets/godot.png"
import android from "@/assets/android.jpg"
import springframework from "@/assets/spring-framework.svg"
import springSecurity from "@/assets/spring-security.svg"
import springData from "@/assets/spring-data.svg"
import springCloud from "@/assets/spring-cloud.svg"
import springBoot from "@/assets/spring-boot.svg"
import kafka from "@/assets/kafka.png"
import springPR from "@/assets/springProjectReactor.png"
import vue from "@/assets/vue.svg"
import keycloak from '@/assets/keycloak.svg'
import postgres from "@/assets/postgres.webp"
import docker from "@/assets/docker.svg"



export default {
  name: "MyStack",
  components: {SkillLine},
  data() {
    return {
      elements: [
        {
          image: java,
          text: 'java',
          visible: false
        },
        {
          image: springframework,
          text: 'spring core',
          visible: false
        },
        {
          image: springBoot,
          text: 'spring boot',
          visible: false

        },
        {
          image: springData,
          text: 'spring data',
          visible: false
        },
        {
          image: springCloud,
          text: 'spring cloud',
          visible: false
        },
        {
          image: springSecurity,
          text: 'spring security',
          visible: false
        },
        {
          image: springPR,
          text: 'spring project reactor',
          visible: false,
          interactive: true
        },
        {
          image: vue,
          text: 'Vue.js',
          visible: false
        },
        {
          image: kafka,
          text: 'kafka',
          visible: false
        },
        {
          image: postgres,
          text: 'postgresql',
          visible: false
        },
        {
          image: keycloak,
          text: 'keycloak',
          visible: false
        },
        {
          image: docker,
          text: 'docker',
          visible: false
        },
        {
          image: android,
          text: 'android',
          visible: false
        },
        {
          image: kotlin,
          text: 'kotlin',
          visible: false
        },
        {
          image: godot,
          text: 'godot',
          visible: false
        },
      ]
    }
  },
  methods: {
    showStepByStep(){
    }
  }
}
</script>

<template>
  <div class="my-stack-container">
    <div class="my-stack-text">Технологии с которыми я работал:</div>
    <div class="my-stack-flex">
      <skill-line v-for="el in elements" :src="el.image" :text="el.text" :interactive="el.interactive"/>
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

.my-stack-text {
  font-family: 'Open Sans', sans-serif;
  font-weight: 400;
  font-size: 18px;
  color: rgba(0, 0, 0, 0.85);
  line-height: 1.5;
  letter-spacing: 0.02em;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-shadow: 0 1px 1px rgba(0,0,0,0.1);
  padding-left: 30px;
}
</style>