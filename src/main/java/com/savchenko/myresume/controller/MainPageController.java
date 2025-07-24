package com.savchenko.myresume.controller;

import com.savchenko.myresume.dto.GptRequestDto;
import com.savchenko.myresume.dto.GptResponseDto;
import com.savchenko.myresume.gpt.GigaChatService;
import com.savchenko.myresume.telegram.TelegramBotService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequiredArgsConstructor
public class MainPageController {
    private final TelegramBotService telegramBotService;

    @GetMapping("/")
    public Mono<Resource> getGptAnswer(ServerHttpRequest request) {
        telegramBotService.sendMessage("Заход на сайт", request.getRemoteAddress().getAddress().getHostAddress());
        return Mono.just(new ClassPathResource("static/index.html"));
    }
}