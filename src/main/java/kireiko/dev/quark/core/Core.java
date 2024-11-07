package kireiko.dev.quark.core;

import kireiko.dev.quark.core.api.AsyncScheduler;
import kireiko.dev.quark.shield.ShieldBridge;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Core extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            AsyncScheduler.run(() -> {
                Message message = update.getMessage();
                if (ShieldBridge.isSpam(message)) {
                    this.delete(ShieldBridge.buildDeleteMessage(message));
                }
            });
        }
    }

    @SneakyThrows
    private void delete(DeleteMessage deleteMessage) {
        this.execute(deleteMessage);
    }

    @Override
    public String getBotUsername() {
        return "QuarkShield";
    }
    @Override
    public String getBotToken() {
        return "7411305381:AAH0ukZOUu9cUQwcaMdgZmoMB6rYEAfRk1M";
    }
}