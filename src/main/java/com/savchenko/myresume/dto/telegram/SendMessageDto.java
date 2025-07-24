package com.savchenko.myresume.dto.telegram;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SendMessageDto {
    private String chatId;
    private String text;
}
