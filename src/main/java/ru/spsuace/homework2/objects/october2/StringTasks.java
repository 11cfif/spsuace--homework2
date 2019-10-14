package ru.spsuace.homework2.objects.october2;

import javax.imageio.stream.ImageInputStream;

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

        if (str == null || str.equals("")) {
            return null;
        }

        String conversionNum = str.replaceAll("[^0-9^e//.//-]","");
        if (!conversionNum.matches("^[-+]?[0-9]*[.,]?[0-9]+(?:[eE][-+]?[0-9]+)?$")) {
            return null;
        }

        if (conversionNum.contains("e") || conversionNum.contains(".")) {
            return Double.valueOf(conversionNum);
        } else if (Long.parseLong(conversionNum) > Integer.MAX_VALUE || Long.parseLong(conversionNum) < Integer.MIN_VALUE) {
            return Long.valueOf(conversionNum);
        } else {
            return Integer.valueOf(conversionNum);
        }
    }

    /**
     * Дополнительно задание
     * Тоже самое, что и выше, но нельзяпользоваться функциями valueOf() и new Integer и тд
     */
    public static Number valueOf(String str) {
        return null;
    }
}
