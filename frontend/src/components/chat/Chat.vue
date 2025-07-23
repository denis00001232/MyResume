<script>
import Message from "@/components/chat/Message.vue";
import axios from "axios";
import message from "@/components/chat/Message.vue";
export default {
  name: "Chat",
  components: {Message},
  data() {
    return {
      message: '',
      messages: [
        {
          isUser: false,
          text: "В этом окне вы можете пообщаться с gpt которая олицетворяет меня и на большую част" +
              "ь вопросов ответила бы также как и я"
        }
      ],
      isWaitingResponse: false
    }
  },
  methods: {
    scrollToBottom() {
      const container = this.$refs.scroll; // Получаем элемент по ref
      if (container) {
        container.scrollTop = container.scrollHeight; // Скроллим в самый низ
      }
    },
    sendMessage() {
      this.isWaitingResponse = true
      const question = {
        isUser: true,
        text: this.message
      }
      this.messages.push(question)
      this.$nextTick(() => this.scrollToBottom());
      axios.post('/api/gpt/question',
          {
            request: this.message
          }
      ).then(
          response => {
            const answer = {
              isUser: false,
              text: response.data.response
            }
            this.messages.push(answer)
            this.isWaitingResponse = false
            this.$nextTick(() => this.scrollToBottom());
          }
      ).catch(
          response => {
            const answer = {
              isUser: false,
              text: 'Error: ошибка на сервере'
            }
            this.messages.push(answer)
            this.isWaitingResponse = false
            this.$nextTick(() => this.scrollToBottom());
          }
      )
      this.message = ''
    }
  }
}
</script>

<template>
  <div class="chat-container">
    <div class="chat-body">
      <div ref="scroll" class="chat-messages">
        <message v-for="m in messages" :text="m.text" :is-user="m.isUser"></message>
        <div v-if="isWaitingResponse" class="chat-loading">
          <div class="chat-loading-point"/>
          <div class="chat-loading-point"/>
          <div class="chat-loading-point"/>
        </div>
      </div>
      <div class="chat-bottom">
        <textarea
            class="textarea"
            v-model="message"
            @keydown.enter.prevent="sendMessage"
            placeholder="Введите сообщение..."
        />
        <button class="button" @click="sendMessage">Отправить</button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.chat-container {
  width: 100%;
  height: 500px;
  background: #d0e7ff;
  border-radius: 20px;
  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
  margin-bottom: 40px;
  margin-top: 40px;
}

.chat-body {
  padding: 20px;
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.chat-messages {
  overflow-y: auto;
  overflow-x: hidden;
  flex: 1;
  border-radius: 20px;
  background: #ffffff;
  padding: 10px;
  scrollbar-width: none; /* Firefox */
  -ms-overflow-style: none; /* IE 10+ */
}

.chat-bottom {
  display: flex;
  align-items: center;
  gap: 10px;
  background: #ffffff;
  border-radius: 12px;
  padding: 10px;
}

.textarea {
  flex: 1;
  resize: none;
  height: 90%;
  padding: 8px 12px;
  font-size: 14px;
  border-radius: 10px;
  border: 1px solid #ccc;
  font-family: inherit;
  outline: none;
  transition: border 0.2s;
  scrollbar-width: none; /* Firefox */
  -ms-overflow-style: none; /* IE 10+ */
}

.textarea:focus {
  border-color: #66afe9;
}

.button {
  height: 40px;
  padding: 0 16px;
  background-color: #4a90e2;
  color: white;
  font-weight: bold;
  border: none;
  border-radius: 10px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.button:hover {
  background-color: #357bd8;
}

.chat-messages::-webkit-scrollbar {
  display: none; /* Chrome, Safari, Edge */
}

.chat-loading {
  height: 30px;
  display: flex;
  justify-content: center;
  gap: 10px;
}

.chat-loading-point {
  background: #393939;
  width: 10px;
  height: 10px;
  border-radius: 50%;
  animation: points 1s ease infinite;
}

@keyframes points {
 0% {
   scale: 1.5;
 }
  50% {
    scale: 1;
  }
  100% {
    scale: 1.5;
  }

}

@media (max-width: 500px) {

}
</style>
