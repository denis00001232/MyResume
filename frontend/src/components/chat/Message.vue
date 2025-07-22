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
  padding: 5px 10px 10px 5px;
  border-radius: 5px;
  word-wrap: break-word;       /* Перенос длинных слов */
  overflow-wrap: break-word;   /* Современный аналог */
  white-space: pre-wrap;
  max-width: 80%;
  background: #80b1e3;
  animation: showing 1s ease;
}

@keyframes showing {
  0% {
    width: 0;
  }
  100% {
    width: 80%;
  }
}
</style>