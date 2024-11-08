package kireiko.dev.quark.shield.text;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Decrypt {
    public static String use(String input) {
        if (input == null || input.isEmpty()) return "";
        input = input.replaceAll("[^\\p{L}\\d!? ]", "").toLowerCase();
        return input;
    }
    public static String deleteRepeat(String input) {
        if (input == null || input.isEmpty()) return "";
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (result.indexOf(String.valueOf(c)) == -1)
                result.append(c);
        }
        return result.toString();
    }
}