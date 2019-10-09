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
        if (checkNullOrEmpty(str)) {
            return null;
        }

        str = firstPassReplace(str);

        if (checkIntegerMatch(str)) {
            Long strToLong = Long.valueOf(str);
            if (strToLong > Integer.MAX_VALUE || strToLong < Integer.MIN_VALUE) {
                return strToLong;
            } else {
                return Integer.valueOf(str);
            }
        }

        if (checkSimpleDoubleMatch(str) || checkScientificDoubleMatch(str)) {
            return Double.valueOf(str);
        }

        return null;
    }


    /**
     * Дополнительно задание
     * Тоже самое, что и выше, но нельзя пользоваться функциями valueOf() и new Integer и тд
     */
    public static Number valueOf(String str) {
        if (checkNullOrEmpty(str)) {
            return null;
        }

        str = firstPassReplace(str);

        if (checkIntegerMatch(str)) {
            long result = parseInteger(str);
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return result;
            } else {
                return (int) result;
            }
        }

        if (checkSimpleDoubleMatch(str)) {
            return parseSimpleDouble(str);
        }

        if (checkScientificDoubleMatch(str)) {
            String[] strParts = str.split("e");
            String mantissaStr = strParts[0];
            String exponentStr = strParts[1];

            double mantissa;
            if (mantissaStr.indexOf('.') == -1) {
                mantissa = (double) parseInteger(mantissaStr);
            } else {
                mantissa = parseSimpleDouble(mantissaStr);
            }

            double exponent = (double) parseInteger(exponentStr);

            return mantissa * Math.pow(10., exponent);
        }

        return null;
    }

    private static String firstPassReplace(String str) {
        return str.replaceAll("[^0-9.e-]", "");
    }

    private static boolean checkNullOrEmpty(String str) {
        return (str == null || str.isEmpty());
    }

    private static boolean checkIntegerMatch(String str) {
        return str.matches("-?[0-9]+");
    }

    private static boolean checkSimpleDoubleMatch(String str) {
        return str.matches("-?[0-9]+\\.[0-9]+");
    }

    private static boolean checkScientificDoubleMatch(String str) {
        return str.matches("-?([0-9]+\\.[0-9]+|[0-9]+)e-?[0-9]+");
    }

    private static int getDigit(String str, int index) {
        return Character.digit(str.charAt(index), 10);
    }

    private static long parseInteger(String str) {
        long result = 0;
        int sign = 1;
        if (str.charAt(0) == '-') {
            sign = -1;
            str = str.substring(1, str.length() - 1);
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            result = result * 10 + getDigit(str, i);
        }
        result *= sign;
        return result;
    }

    private static double parseSimpleDouble(String str) {
        double result;
        int sign = 1;

        if (str.charAt(0) == '-') {
            sign = -1;
            str = str.substring(0, str.length() - 1);
        }

        String[] strParts = str.split("\\.");
        long intPart = parseInteger(strParts[0]);
        double fractionalPart = parseInteger(strParts[1]) * Math.pow(10., - strParts[1].length());
        result = sign * (intPart + fractionalPart);
        return result;
    }
}
