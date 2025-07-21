package com.savchenko.myresume.gpt;

import com.savchenko.myresume.dto.GigaChatRequestDto;
import com.savchenko.myresume.model.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class MessageConvertor {
    private GigaChatRequestDto gigaChatRequestDto = new GigaChatRequestDto();
    private Message systemMessage = new Message("system", """
            Отвечай как Денис Савченко, тебе 22 года ты java-разработчик со стажем два года, знаешь Spring.
            """);


    public GigaChatRequestDto setUserQuestion(String question) {
        List<Message> messages = new ArrayList<>();
        messages.add(systemMessage);
        Message userMessage = new Message("user", question);
        messages.add(userMessage);
        gigaChatRequestDto.setMessages(messages);
        return gigaChatRequestDto;
    }

    public void setSystemQuestion(String message) {
        systemMessage = new Message("system", message);
    }
}
