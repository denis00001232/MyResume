package com.savchenko.myresume.controller;

import com.savchenko.myresume.dto.GptRequestDto;
import com.savchenko.myresume.dto.GptResponseDto;
import com.savchenko.myresume.gpt.GigaChatService;
import com.savchenko.myresume.gpt.SpamFilter;
import com.savchenko.myresume.telegram.TelegramBotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/gpt")
@RequiredArgsConstructor
public class GptController {
    private final GigaChatService gigaChatService;
    private final TelegramBotService telegramBotService;
    private final SpamFilter spamFilter;

    @PostMapping("/question")
    public Mono<GptResponseDto> getGptAnswer(@RequestBody GptRequestDto gptRequestDto, ServerHttpRequest request) {
        telegramBotService.sendMessage(gptRequestDto.getRequest(), request.getRemoteAddress().getAddress().getHostAddress());
        if (spamFilter.filter(request.getRemoteAddress().getAddress().getHostAddress())) {
            return Mono.just(new GptResponseDto("Вы потратили 3 попытки, напишите через час"));
        }
        return gigaChatService.getGptResponse(gptRequestDto.getRequest());
    }

}
