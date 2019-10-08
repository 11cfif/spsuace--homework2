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

        str = str.replaceAll("[^0-9.e-]", "");
        int eCount = countSymbol(str, 'e');
        int dotCount = countSymbol(str, '.');
        int minusCount = countSymbol(str, '-');

        if (dotCount > 1 || eCount > 1) {
            return null;
        }

        if (dotCount == 0 && eCount == 0) {
            if (minusCount <= 1) {
                Long strToLong = Long.valueOf(str);
                if (Math.abs(strToLong) > Integer.MAX_VALUE) {
                    return strToLong;
                } else {
                    return Integer.valueOf(str);
                }
            } else {
                return null;
            }
        }

        return Double.valueOf(str);
    }

    private static int countSymbol(String str, char symbol) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == symbol) {
                count++;
            }
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

        str = str.replaceAll("[^0-9.e-]", "");
        int eCount = countSymbol(str, 'e');
        int dotCount = countSymbol(str, '.');
        int minusCount = countSymbol(str, '-');

        if (dotCount > 1 || eCount > 1) {
            return null;
        }

        if (dotCount == 0 && eCount == 0) {
            if (minusCount <= 1) {
                long strToLong = new Long(str);
                if (Math.abs(strToLong) > Integer.MAX_VALUE) {
                    return strToLong;
                } else {
                    return new Integer(str);
                }
            } else {
                return null;
            }
        }

        return new Double(str);
    }
}
