package ru.spsuace.homework2.objects.october2;

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
        int countDots = str.length() - str.replace(".", "").length();
        if ((countDots) > 1 || (str.length() - str.replace("e", "").length()) > 1) {
            return null;
        }

        str = str.replaceAll("(?<!^)[\\-]+", "");
        str = str.replaceAll("[^0-9e\\-.]+", "");


        if (countDots > 0) {
            return Double.valueOf(str);
        }
        return Integer.valueOf(str);
    }


    /**
     * Дополнительно задание
     * Тоже самое, что и выше, но нельзя пользоваться функциями valueOf() и new Integer и тд
     */
    public static Number valueOf(String str) {
        return null;
    }
}
