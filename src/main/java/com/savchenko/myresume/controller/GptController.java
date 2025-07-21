package com.savchenko.myresume.controller;

import com.savchenko.myresume.dto.GptRequestDto;
import com.savchenko.myresume.dto.GptResponseDto;
import com.savchenko.myresume.gpt.GigaChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/gpt")
@RequiredArgsConstructor
public class GptController {
    private final GigaChatService gigaChatService;

    @PostMapping("/question")
    public Mono<GptResponseDto> getGptAnswer(@RequestBody GptRequestDto gptRequestDto) {
        return gigaChatService.getGptResponse(gptRequestDto.getRequest());
    }
}
