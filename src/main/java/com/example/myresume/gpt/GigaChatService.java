package com.example.myresume.gpt;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@EnableScheduling
public class GigaChatService {
    WebClient webClient = WebClient.builder()
            .baseUrl("https://ngw.devices.sberbank.ru:9443")
            .build();

    private String authorization =
            "NDJkMjY5MzctMDJmMS00ZGQ4LTg4OTMtMDZhMzM1NjI1NjUxOmNiNGYyMGIxLTE4Y2YtNDM2My1iZGQ5LTgzM2NjMzE4ZjA2Zg==";
    private String RqUID = "42d26937-02f1-4dd8-8893-06a335625651";


    @Scheduled(fixedRate = 5000, initialDelay = 0)
    private void updateToken() {
        webClient.post().
                uri("/api/v2/oauth").
                header("RqUID", RqUID).
                header("Authorization", authorization).
                retrieve().bodyToMono(String.class).map(info);
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
