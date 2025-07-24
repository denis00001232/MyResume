<script>
import mePDF from '@/assets/Денис_Савченко.pdf'
export default {
  name: "Links",
  data() {
    return {
      mePDF
    }
  }
}
</script>

<template>
  <div class="links-container">
    <a href="https://t.me/Denis_Savchenko" target="_blank" class="telegram-btn">
      <img src="@/assets/telegram.svg" alt="Telegram" />
      <span class="pdf-button__text">Написать в Telegram.</span>
    </a>
    <a href="https://hh.ru/resume/b4845011ff0f28b1980039ed1f307671584746?from=share_ios" target="_blank" class="hh-button">
      Открыть резюме на hh.ru
    </a>
    <a
        :href="mePDF"
        download
        class="pdf-button"
    >
      <span class="pdf-button__text">Резюме в PDF</span>
      <span class="pdf-button__icon">↓</span>
    </a>
  </div>
</template>

<style scoped>
.links-container {
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  gap: 40px;
  margin-top: 40px;
}
.telegram-btn {
  display: inline-flex;
  align-items: center;
  gap: 10px;
  background-color: #229ED9;
  color: white;
  font-family: 'Segoe UI', sans-serif;
  font-size: 16px;
  padding: 10px 20px;
  border-radius: 999px;
  text-decoration: none;
  border: none;
  cursor: pointer;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
  transition: background-color 0.3s ease, transform 0.2s ease;
}

.telegram-btn img {
  width: 20px;
  height: 20px;
}

.telegram-btn:hover {
  background-color: #1b8ec1;
  transform: translateY(-2px);
}

.hh-button {
  display: inline-block;
  padding: 12px 24px;
  background-color: #ff334d; /* фирменный красный hh */
  color: #ffffff;
  font-family: 'Arial', sans-serif;
  font-size: 16px;
  font-weight: bold;
  border-radius: 4px;
  text-decoration: none;
  border: none;
  transition: background-color 0.3s ease, transform 0.2s ease;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.15);
}

.hh-button:hover {
  background-color: #ff334d;
  transform: translateY(-1px);
}

.pdf-button {
  display: inline-flex;
  align-items: center;
  gap: 8px;
  padding: 12px 24px;
  background-color: #4f46e5; /* Индиго */
  color: white;
  border-radius: 8px;
  text-decoration: none;
  font-weight: 600;
  font-family: 'Inter', sans-serif;
  transition: all 0.3s ease;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  border: none;
  cursor: pointer;
}

.pdf-button:hover {
  background-color: #4338ca; /* Темнее индиго */
  transform: translateY(-2px);
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.15);
}

.pdf-button:active {
  transform: translateY(0);
}

.pdf-button__icon {
  font-size: 1.2em;
}
</style>