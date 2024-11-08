package kireiko.dev.quark.shield.text;

import lombok.experimental.UtilityClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class AdInitials {

    private static final String[] scam = new String[]{
                    "usdt", "btc", "near", "bnb", "not", "ldo", "giveaway",
                    "dash", "op", "perehodi", "v profil", "bio", "drop",
                    "kanal", "shapke", "profilya", "s'y'lk'a", "v'bio'",
                    "telegram", "vip", "rune", "profit", "cats", "futures",
                    "trading", "winrate", "credit", "deposit", "withdrawal",
                    "sign-up bonus", "team commission", "daily earnings",
                    "referral program", "investment", "trading signals",
                    "platform", "vip1", "vip2", "vip3", "antgpt",
                    "automated trading", "platinum",
                    "invite friends", "usdt bonus",
                    "quantitative trading", "smart algorithm",
                    "3%", "10%", "5%", "4%", "profit", "fire drops",
                    "gains", "monet", "trader", "method", "lesson",
                    "free", "link", "consultation", "opportunity", "guarantee",
                    "заработок", "инвест", "прибыль", "бонус", "платформа",
                    "реферальная программа", "торговля", "торговые сигналы",
                    "автоматическая торговля", "пригласить друзей", "профит",
                    "обучение", "урок", "криптовалюта", "доход", "ежедневный заработок",
                    "кредит", "депозит", "снятие", "вложен", "ворк",
                    "приглашение", "гарантия", "возможность", "консультация"
    };

    public static int checkCount(String s) {
        String regex = "[€$¥£₽₴₹₿%+@]|\\b\\d+(\\.\\d{1,2})?\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        int count = 0;
        while (matcher.find())
            count++;
        return count;
    }

    public static int checkCountryFlags(String s) {
        String countryRegex = "\\b[A-Z]{2}\\b";
        Pattern pattern = Pattern.compile(countryRegex);
        Matcher matcher = pattern.matcher(s);
        int count = 0;
        while (matcher.find())
            count++;
        return count;
    }

    public static boolean isScam(String s) {
        for (String i : scam) {
            if (Decrypt.deleteRepeat(
                            s.toLowerCase()).contains(i)
                            || Decrypt.use(s.toLowerCase()).contains(i)
                            || s.toLowerCase().contains(i)) return true;
        }
        return false;
    }
}

