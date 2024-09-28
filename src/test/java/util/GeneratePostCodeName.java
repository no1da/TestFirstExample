package util;

import java.util.Random;
/**
 * Класс для генерации Post Code и преобразования его в First Name.
 * <p>
 * Этот класс предоставляет методы для генерации случайного
 * Post Code и преобразования Post Code в First Name,
 * используя определенные алгоритмы для преобразования чисел
 * в символы.
 * </p>
 */
public class GeneratePostCodeName {
    /**
     * Генерирует случайный Post Code в виде строки.
     * <p>
     * Методу присвоен диапазон от 1000000000 до 9999999999,
     * что обеспечивает 10-значное число.
     * </p>
     *
     * @return сгенерированный Post Code в виде строки.
     */
    public static String generatePostCode() {
        Random random = new Random();
        long postcode = 1000000000L + (long) (random.nextDouble() * 9000000000L);
        return Long.toString(postcode);
    }
    /**
     * Преобразует Post Code в First Name, используя определенные правила.
     * <p>
     * Каждые две цифры Post Code превращаются в
     * букву английского алфавита, где 0 соответствует 'a',
     * 1 - 'b' и так далее, с использованием математической
     * операции для достижения корректного диапазона символов.
     * </p>
     *
     * @param postCode почтовый код, который будет преобразован.
     * @return First Name, основанное на входном почтовом коде.
     */
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


