package com.lapitus.controller;

import com.lapitus.config.TelegramBotConfig;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@Log4j
public class TelegramBotController extends TelegramLongPollingBot {

    final TelegramBotConfig telegramBotConfig;

    public TelegramBotController(TelegramBotConfig telegramBotConfig) {
        this.telegramBotConfig = telegramBotConfig;
    }

    @Override
    public void onUpdateReceived(Update update) {
        var originalMessage = update.getMessage();
        log.info(originalMessage.getText());
    }

    @Override
    public String getBotToken() {
        return telegramBotConfig.getToken();
    }

    @Override
    public String getBotUsername() {
        return telegramBotConfig.getBotName();
    }

}
