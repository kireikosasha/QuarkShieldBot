package kireiko.dev.quark.shield;

import kireiko.dev.quark.core.Core;
import kireiko.dev.quark.core.api.Logger;
import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new Core());
        Logger.info("QuarkShield session started.");
    }
}