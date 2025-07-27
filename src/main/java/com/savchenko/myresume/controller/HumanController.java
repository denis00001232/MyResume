package com.savchenko.myresume.controller;

import com.savchenko.myresume.telegram.TelegramBotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/observer")
public class HumanController {
    private final TelegramBotService telegramBotService;

    @PostMapping("/action")
    public Mono<String> actionListener(ServerHttpRequest serverHttpRequest, @RequestHeader String action) {
        telegramBotService.sendMessage(action, serverHttpRequest.getRemoteAddress().getAddress().getHostAddress());
        return Mono.empty();
    }
}