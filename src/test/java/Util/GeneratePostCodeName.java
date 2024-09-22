package Util;

import java.util.Random;

public class GeneratePostCodeName {
    public static String generatePostCode() {
        Random random = new Random();
        long postcode = 1000000000L + (long) (random.nextDouble() * 9000000000L);
        return Long.toString(postcode);
    }

    public static String convertToName(String postCode) {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < postCode.length(); i += 2) {
            String twoDigit = postCode.substring(i, i + 2);
            int value = Integer.parseInt(twoDigit);
            char letter = (char) ('a' + (value % 26));
            name.append(letter);
        }
        return name.toString();
    }
}


