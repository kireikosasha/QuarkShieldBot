package kireiko.dev.quark.shield.text;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Decrypt {
    public static String use(String input) {
        if (input == null || input.isEmpty()) return "";
        input = input.replaceAll("[^\\p{L}\\d!? ]", "").toLowerCase();
        return input;
    }
}