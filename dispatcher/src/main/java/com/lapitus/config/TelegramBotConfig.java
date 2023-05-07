package com.lapitus.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("telegram")
public class TelegramBotConfig {
    //test

    private String botName;
    private String token;
}
