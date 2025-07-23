<script>
export default {
  name: "Message",
  props: {
    text: {
      type: String
    },
    isUser: {
      type: Boolean
    }
  },
  computed: {
    color() {
      if(this.isUser) {
        return {
          background: '#80b1e3',
          marginLeft: 'auto'
        }
      } else {
        return {
          background: '#80e3ab',
          marginRight: 'auto'
        }
      }
    }
  }
}
</script>

<template>
  <div class="message-container" :style="color">{{text}}</div>
</template>

<style scoped>
.message-container {
  margin: 10px;
  padding: 10px;
  border-radius: 20px;
  word-wrap: break-word;       /* Перенос длинных слов */
  overflow-wrap: break-word;   /* Современный аналог */
  white-space: pre-wrap;
  max-width: 80%;
  background: #80b1e3;
  animation: showing 1s ease;
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

@keyframes showing {
  0% {
    opacity: 0;
  }
  100% {
    opacity: 100%;
  }
}
</style>