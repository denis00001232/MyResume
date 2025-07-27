package com.savchenko.myresume.telegram;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class TelegramBotService {
    private String botToken = "8288068751:AAFJdBSmHK1XchwCZDJ6ZfTg1fDGCZgqiUg";
    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://api.telegram.org/bot" + botToken)
            .build();


    public void sendMessage(String message, String ip) {
        webClient.get().
                uri(uriBuilder -> uriBuilder
                        .path("/sendMessage")
                        .queryParam("chat_id", "1043989413")  // Добавляем параметры
                        .queryParam("text", "Отправлено с(" + ip + "): " + message)
                        .build()).
                retrieve().
                bodyToMono(String.class).subscribe();
    }
}
