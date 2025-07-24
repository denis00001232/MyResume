package com.savchenko.myresume.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.savchenko.myresume.model.Message;
import lombok.Data;

import java.util.List;

@Data
public class GigaChatRequestDto {
    private String model = "GigaChat-2";
    private boolean stream = false;
    @JsonProperty("update_interval")
    private int updateInterval = 0;
    private List<Message> messages;
}