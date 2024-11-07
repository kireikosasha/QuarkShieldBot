package kireiko.dev.quark.shield;

import kireiko.dev.quark.core.api.Logger;
import kireiko.dev.quark.shield.text.Decrypt;
import lombok.experimental.UtilityClass;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@UtilityClass
public class ShieldBridge extends Logger {

    public static boolean isSpam(Message message) {
        info("decom: " + Decrypt.use(message.getText()));
        return false;
    }
    public static DeleteMessage buildDeleteMessage(Message message) {
        DeleteMessage deleteMessage = new DeleteMessage();
        deleteMessage.setChatId(message.getChatId().toString());
        deleteMessage.setMessageId(message.getMessageId());
        return deleteMessage;
    }
}
