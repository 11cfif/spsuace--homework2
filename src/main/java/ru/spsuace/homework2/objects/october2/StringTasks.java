package ru.spsuace.homework2.objects.october2;
import java.util.regex.*;

public class StringTasks {

    /**
     * Убрать все лишние символы из строки и вернуть получившееся число.
     * Разрешенные символы: цифры, '-', '.', 'e'
     * Если '.' и 'e' больше чем 1, возвращаем null
     * Правила на '-' является валидность числа. --3 не валидно. -3e-1 валдино
     * Любой класс-обертка над примитивами наследуется от Number
     * Можно использовать функции Double.valueOf() и другие такие же.
     *
     * Работайте со строкой, НЕ надо ее переводить в массив байт (это можно использовать только для цикла)
     * У класса Character есть полезные методы, например Character.isDigit()
     */
    public static Number simpleValueOf(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }

        int countD = str.length() - str.replace(".", "").length();
        int countE = str.length() - str.replace("e", "").length();
        if (countD > 1 || countE > 1) {
            return null;
        }

        str = str.replaceAll("[^0-9e\\-.]+", "");
        Pattern pattern = Pattern.compile("(?<!^)(?<!e)[\\-]");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return null;
        }

        if (countD > 0 || countE > 0) {
            return Double.valueOf(str);
        }
        try {
            return Integer.valueOf(str);
        }
        catch(NumberFormatException exception) {
            return Long.valueOf(str);
        }
    }


    /**
     * Дополнительно задание
     * Тоже самое, что и выше, но нельзя пользоваться функциями valueOf() и new Integer и тд
     */
    public static Number valueOf(String str) {
        return null;
    }
}
