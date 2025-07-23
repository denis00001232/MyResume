import { fileURLToPath, URL } from 'node:url'
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'

// https://vitejs.dev/config/
export default defineConfig({
  server: {
    host: 'localhost',
    port: 5173, // порт Vite
    proxy: {
      // Проксировать ВСЕ запросы к /api на localhost:8080
      '/api': {
        target: 'http://localhost:80',
        changeOrigin: true,
        rewrite: path => path.replace(/^\/api/, '/api'),
      },
    },
  },
  plugins: [
    vue(),
    vueDevTools(),
  ],
  build: {
    outDir: '../src/main/resources/static', // Куда класть билд
    assetsDir: 'static-inner',        // Папка для статики внутри outDir
    emptyOutDir: true           // Очищать папку перед сборкой
  },
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },
})
