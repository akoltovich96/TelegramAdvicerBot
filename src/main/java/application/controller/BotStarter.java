package application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@RestController
public class BotStarter {

    private final BotRegister botRegister;

    public BotStarter(BotRegister botRegister) {
        this.botRegister = botRegister;
    }

    @GetMapping("/startBot")
    public void startBot() throws TelegramApiRequestException {
        botRegister.init();
    }
}