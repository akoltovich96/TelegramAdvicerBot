package application.controller;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@Component
public class BotRegister {

    private final BotController botController;

    public BotRegister(BotController botController) {
        this.botController = botController;
    }


    public void init() throws TelegramApiRequestException {
        TelegramBotsApi botsApi = new TelegramBotsApi();
        botsApi.registerBot(botController);
    }
}