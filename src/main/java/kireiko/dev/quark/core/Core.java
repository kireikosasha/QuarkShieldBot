package kireiko.dev.quark.core;

import kireiko.dev.quark.core.api.AsyncScheduler;
import kireiko.dev.quark.core.api.Logger;
import kireiko.dev.quark.shield.ShieldBridge;
import kireiko.dev.quark.shield.text.Check;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Core extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()
                        && update.getMessage().getChatId() != null
                        && update.getMessage().getMessageId() != null) {
            AsyncScheduler.run(() -> {
                Message message = update.getMessage();
                Check result = ShieldBridge.check(message);
                if (result.isSpam()) {
                    this.delete(ShieldBridge.buildDeleteMessage(message), result, message);
                }
            });
        }
    }

    @SneakyThrows
    private void delete(DeleteMessage deleteMessage, Check result, Message message) {
        this.execute(deleteMessage);
        if (message.getFrom().getUserName() != null) {
            String logMessage = message.getFrom().getUserName()
                            + " message deleted (type: "
                            + result.getType() + ") ["
                            + result.getDeviace() + "]";
            Logger.punish(logMessage);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId("1163654118");
            sendMessage.setText(logMessage);
            this.execute(sendMessage);
        }
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