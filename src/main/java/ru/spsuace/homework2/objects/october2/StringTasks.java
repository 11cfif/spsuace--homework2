package ru.spsuace.homework2.objects.october2;

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

        String changeStr = str.replaceAll("[^0-9^e//.//-]", "");
        if (!changeStr.matches("^[-+]?[0-9]*[.,]?[0-9]+(?:[eE][-+]?[0-9]+)?$")) {
            return null;
        }

        if (changeStr.contains("e") || changeStr.contains(".")) {
            return Double.valueOf(changeStr);
        } else if (Long.valueOf(changeStr) > Integer.MAX_VALUE || Long.valueOf(changeStr) < Integer.MIN_VALUE) {
            return Long.valueOf(changeStr);
        } else {
            return Integer.valueOf(changeStr);
        }
    }

    /**
     * Дополнительно задание
     * Тоже самое, что и выше, но нельзя пользоваться функциями valueOf() и new Integer и тд
     */
    public static Number valueOf(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        String changeStr = str.replaceAll("[^0-9^e//.//-]", "");
        if (!changeStr.matches("^[-+]?[0-9]*[.,]?[0-9]+(?:[eE][-+]?[0-9]+)?$")) {
            return null;
        }

        if (changeStr.contains("e") || changeStr.contains(".")) {

            return Double.parseDouble(changeStr);
        } else if (Long.parseLong(changeStr) > Integer.MAX_VALUE || Long.parseLong(changeStr) < Integer.MIN_VALUE) {
            return Long.parseLong(changeStr);
        }
        return Integer.parseInt(changeStr);
    }
}


