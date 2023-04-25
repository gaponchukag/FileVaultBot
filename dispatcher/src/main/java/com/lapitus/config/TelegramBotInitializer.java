package com.lapitus.config;

import com.lapitus.controller.TelegramBotController;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Log4j
@Component
public class TelegramBotInitializer {
    final TelegramBotController telegramBotController;

    public TelegramBotInitializer(TelegramBotController telegramBotController) {
        this.telegramBotController = telegramBotController;
    }

    @EventListener({ContextRefreshedEvent.class})
    public void init() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(telegramBotController);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }
}
