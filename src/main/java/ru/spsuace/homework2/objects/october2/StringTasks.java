package ru.spsuace.homework2.objects.october2;

import java.util.regex.Pattern;

public class StringTasks {

    /**
     * Убрать все лишние символы из строки и вернуть получившееся число.
     * Разрешенные символы: цифры, '-', '.', 'e'
     * Если '.' и 'e' больше чем 1, возвращаем null
     * Правила на '-' является валидность числа. --3 не валидно. -3e-1 валдино
     * Любой класс-обертка над примитивами наследуется от Number
     * Можно использовать функции Double.valueOf() и другие такие же.
     * <p>
     * Работайте со строкой, НЕ надо ее переводить в массив байт (это можно использовать только для цикла)
     * У класса Character есть полезные методы, например Character.isDigit()
     */
    public static Number simpleValueOf(String str) {

        if (str == null || str.isEmpty()) {
            return null;
        }

        String resultString = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-' || Character.isDigit(str.charAt(i)) || str.charAt(i) == 'e' || str.charAt(i) == '.') {
                resultString += str.charAt(i);
            }
        }

        if (resultString.matches("-?[0-9]+")) {
            if (Long.valueOf(resultString) > Integer.MAX_VALUE || Long.valueOf(resultString) < Integer.MIN_VALUE) {
                return Long.valueOf(resultString);
            }
            return Integer.valueOf(resultString);
        }

        if (resultString.matches("-?[0-9]+e-?[0-9]+")) {
            return Double.valueOf(resultString);
        }

        if (resultString.matches("-?[0-9]+\\.[0-9]+e-?[0-9]+")) {
            return Double.valueOf(resultString);
        }

        if (resultString.matches("-?[0-9]+\\.[0-9]")) {
            return Double.valueOf(resultString);
        }

        return null;
    }


    /**
     * Дополнительно задание
     * Тоже самое, что и выше, но нельзя пользоваться функциями valueOf() и new Integer и тд
     */
    public static Number valueOf(String str) {
        return null;
    }
}
