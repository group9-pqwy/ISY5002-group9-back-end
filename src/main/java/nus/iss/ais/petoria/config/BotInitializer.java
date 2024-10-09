package nus.iss.ais.petoria.config;

import lombok.extern.slf4j.Slf4j;
import nus.iss.ais.petoria.controller.BotController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
@Slf4j
public class BotInitializer implements CommandLineRunner {

    private final BotController botController;

    public BotInitializer(BotController botController) {
        this.botController = botController;
    }

    @Override
    public void run(String... args) throws Exception {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            botsApi.registerBot(botController);
            log.info("Telegram bot registered successfully.");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}