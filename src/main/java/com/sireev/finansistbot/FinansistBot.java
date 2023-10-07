package com.sireev.finansistbot;

import com.sireev.finansistbot.configuration.BotConfig;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class FinansistBot extends TelegramLongPollingBot {

    @Value("${telegram.bot-name}")
    private String botName;

    public FinansistBot(@Value("${telegram.bot-token}") String botToken,
                        BotConfig botConfig) {
        super(botToken);
    }
    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            long chatId = update.getMessage().getChatId();
            String messageText = update.getMessage().getText();
            String[] msgList = messageText.split(" ");
            Map<String, String> words = new HashMap<>();
            sendMessage(chatId, "1");
        }
    }


    @Override
    public String getBotUsername() {
        return botName;
    }

    private void sendMessage(Long chatId, String textToSend){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(textToSend);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


}
