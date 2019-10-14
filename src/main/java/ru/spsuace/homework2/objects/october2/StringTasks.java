package ru.spsuace.homework2.objects.october2;


import java.util.regex.Pattern;
import java.util.regex.Matcher;

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
        String res = "";
        Pattern pattern = Pattern.compile("\\d|e|-|\\.");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            res += str.substring(matcher.start(), matcher.end());
        }
        pattern = Pattern.compile("e");
        int count = GetCount(pattern, str);
        if (count > 1) {
            return null;
        }
        pattern = Pattern.compile("\\.");
        count = GetCount(pattern, str);
        if (count > 1) {
            return null;
        }
        pattern = Pattern.compile("-");
        count = GetCount(pattern, str);
        if (count > 1) {
            if (res.toCharArray()[0] == '-' && res.toCharArray()[1] == '-') {
                return null;
            }
        }
        try {
            return Integer.valueOf(res);
        } catch (Exception e1) {
            try {
                return Long.valueOf(res);
            } catch (Exception e2) {
                try {
                    return Double.valueOf(res);
                } catch (Exception e3) {
                    return null;
                }
            }
        }
    }

    private static int GetCount(Pattern pattern, String str) {
        int count = 0;
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    /**
     * Дополнительно задание
     * Тоже самое, что и выше, но нельзя пользоваться функциями valueOf() и new Integer и тд
     */
    public static Number valueOf(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        String res = "";
        Pattern pattern = Pattern.compile("\\d|e|-|\\.");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            res += str.substring(matcher.start(), matcher.end());
        }
        pattern = Pattern.compile("e");
        int count = GetCount(pattern, str);
        if (count > 1) {
            return null;
        }
        pattern = Pattern.compile("\\.");
        count = GetCount(pattern, str);
        if (count > 1) {
            return null;
        }
        pattern = Pattern.compile("-");
        count = GetCount(pattern, str);
        if (count > 1) {
            if (res.toCharArray()[0] == '-' && res.toCharArray()[1] == '-') {
                return null;
            }
        }
        try {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
