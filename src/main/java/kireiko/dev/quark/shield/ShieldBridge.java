package kireiko.dev.quark.shield;

import kireiko.dev.quark.core.api.Logger;
import kireiko.dev.quark.shield.math.MathBuilder;
import kireiko.dev.quark.shield.text.Check;
import kireiko.dev.quark.shield.text.Decrypt;
import kireiko.dev.quark.shield.constant.SpamType;
import lombok.experimental.UtilityClass;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@UtilityClass
public class ShieldBridge extends Logger {

    public static Check check(Message message) {

        String basic = message.getText();
        String format = Decrypt.use(basic);
        int deltaB2F = basic.length() - format.length();
        float percent = ((float) deltaB2F / basic.length()) * 100.0F;
        /*
        info("p: " + (int) percent + "%");
        info("Обычно: " + basic + " Форматировано: " + format);
         */
        if (basic.length() > 50 && percent > 15.0F) {
            return new
                   Check(
                   true,
                   SpamType.AD_BANNER,
                   MathBuilder.buildDeviance(percent));
        }
        return new Check(false, null, null);
    }
    public static DeleteMessage buildDeleteMessage(Message message) {
        DeleteMessage deleteMessage = new DeleteMessage();
        deleteMessage.setChatId(message.getChatId().toString());
        deleteMessage.setMessageId(message.getMessageId());
        return deleteMessage;
    }
}
