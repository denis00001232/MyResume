package com.savchenko.myresume.gpt;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.savchenko.myresume.dto.GigaChatRequestDto;
import com.savchenko.myresume.dto.GptResponseDto;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.slf4j.Logger;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;
import java.util.concurrent.TimeUnit;

@Service
@EnableScheduling
public class GigaChatService {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(GigaChatService.class);
    private SslContext sslContext;

    {
        try {
            sslContext = SslContextBuilder.forClient()
                    .trustManager(InsecureTrustManagerFactory.INSTANCE)
                    .build();
        } catch (SSLException e) {
            throw new RuntimeException(e);
        }
    }

    private final HttpClient httpClient = HttpClient.create()
            .secure(spec -> spec.sslContext(sslContext));

    private final WebClient webClient = WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector(httpClient))
            .baseUrl("https://ngw.devices.sberbank.ru:9443")
            .build();

    private String authorization =
            "NDJkMjY5MzctMDJmMS00ZGQ4LTg4OTMtMDZhMzM1NjI1NjUxOmNiNGYyMGIxLTE4Y2YtNDM2My1iZGQ5LTgzM2NjMzE4ZjA2Zg==";

    private String RqUID = "42d26937-02f1-4dd8-8893-06a335625651";

    private ObjectMapper objectMapper = new ObjectMapper();

    private String accessToken;

    public GigaChatService() {
    }


    @Scheduled(fixedRate = 600, initialDelay = 0, timeUnit = TimeUnit.SECONDS)
    private void updateToken() {
        webClient.post().
                uri("/api/v2/oauth").
                header("RqUID", RqUID).
                header("Authorization", "Bearer " + authorization).
                header("Content-Type", "application/x-www-form-urlencoded").
                header("Accept", "application/json").
                bodyValue("scope=GIGACHAT_API_PERS").
                retrieve().bodyToMono(String.class).subscribe(json -> {
                    try {
                        JsonNode rootNode = objectMapper.readTree(json);
                        accessToken = rootNode.get("access_token").textValue();
                    } catch (JsonProcessingException e) {
                        log.error(e.getMessage());
                    }
                });
    }

    public Mono<GptResponseDto> getGptResponse(String userRequest) {
        MessageConvertor messageConverter = new MessageConvertor();
        GigaChatRequestDto gigaChatRequestDto = messageConverter.setUserQuestion(userRequest);
        try {
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(gigaChatRequestDto));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return webClient.post().
                uri("https://gigachat.devices.sberbank.ru/api/v1/chat/completions").
                header("Authorization", "Bearer " + accessToken).
                header("Content-Type", "application/json").
                bodyValue(gigaChatRequestDto).
                retrieve().bodyToMono(String.class).handle((json, sink) -> {
                    try {
                        JsonNode rootNode = objectMapper.readTree(json);
                        GptResponseDto gptResponseDto = new GptResponseDto();
                        gptResponseDto.setResponse(rootNode.
                                get("choices").
                                get(0).
                                get("message").
                                get("content").
                                textValue());
                        sink.next(gptResponseDto);
                    } catch (JsonProcessingException e) {
                        sink.error(new RuntimeException(e));
                    }
                });
    }

}
/*
curl -L -X POST 'https://ngw.devices.sberbank.ru:9443/api/v2/oauth' \
-H 'Content-Type: application/x-www-form-urlencoded' \
-H 'Accept: application/json' \
-H 'RqUID: c5c02a25-5af5-443a-8fbc-f275fca51deb' \
-H 'Authorization: Basic <Authorization key>' \
--data-urlencode 'scope=GIGACHAT_API_PERS'
 */
