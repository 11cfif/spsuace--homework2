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

        if (str == null || str == "") {
            return null;
        }
        String[] strCopy = new String[str.length()];
        String strAnswer = "";

        for (int i = 0; i < str.length(); i++) {
            strCopy[i] = String.valueOf(str.charAt(i));
        }

        for (int i = 0; i < str.length(); i++) {
            if (strCopy[i].matches("[-e.]*[0-9]*")) {
                strAnswer += str.charAt(i);
            }
        }
        String[] current = signAndString(strAnswer);
        if (!strAnswer.matches("-?[0-9]+")) {
            if (strAnswer.matches("-?[0-9]+\\.[0-9]+") ||
                    strAnswer.matches("-?([0-9]+\\.[0-9]+|[0-9]+)e-?[0-9]+")) {
                return strToDouble(strAnswer);
            }
            return null;
        }
        if ((Long.valueOf(strAnswer) > Integer.MAX_VALUE) || (Long.valueOf(strAnswer) < Integer.MIN_VALUE)) {
            return StrToLong(current[1], current[0]);
        }
        return strToInt(current[1], current[0]);
    }

    private static int strToInt(String str1, String strSign) {
        int answer = 0;
        int sign = 1;
        if (strSign.charAt(0) == '-') {
            sign = -1;
        }
        for (int i = 0; i < str1.length(); i++) {
            answer += (int) Math.pow(10, str1.length() - i - 1) * Character.digit(str1.charAt(i), 10);
        }
        return sign * answer;
    }

    private static long StrToLong(String str1, String strSign) {
        long answer = 0;
        long sign = 1;
        if (strSign.charAt(0) == '-') {
            sign = -1;
        }
        for (int i = 0; i < str1.length(); i++) {
            answer += (long) Math.pow(10, str1.length() - i - 1) * Character.digit(str1.charAt(i), 10);
        }
        return sign * answer;
    }

    private static String[] signAndString(String str1) {
        String[] str2 = new String[2];
        str2[0] = "+";
        str2[1] = str1;
        if (str1.charAt(0) == '-') {
            str2 = str1.split("-", 2);
            str2[0] = "-";
        }
        return str2;
    }

    private static String[] intFractParts(String str1) {
        String[] str2 = new String[2];
        str2[0] = str1;
        str2[1] = "0";
        if (str1.matches("[0-9]*\\.[0-9]*")) {
            str2 = str1.split("\\.");
        }
        return str2;
    }

    private static String[] expPart(String str1) {
        double answer = 0;
        String[] str2 = new String[2];
        str2[0] = str1;
        str2[1] = "0";
        if (str1.matches("[0-9]*.?[0-9]*e-?[0-9]*")) {
            str2 = str1.split("e");
        }
        return str2;
    }

    private static double expPow(String str1) {
        String[] str2 = new String[2];
        str2 = signAndString(str1);

        return Math.pow(10, strToInt(str2[1], str2[0]));
    }

    private static double strToDouble(String str1) {
        String[] minusTest = new String[2];
        minusTest = signAndString(str1);
        String[] dotTest;
        String[] expTest;
        expTest = expPart(minusTest[1]);
        dotTest = intFractParts(expTest[0]);
        double beforeDot = strToInt(dotTest[0], minusTest[0]);
        double afterDot = strToInt(dotTest[1], "+") * Math.pow(10, -dotTest[1].length());
        double afterExp = expPow(expTest[1]);
        return (beforeDot + afterDot) * afterExp;
    }

    /**
     * Дополнительно задание
     * Тоже самое, что и выше, но нельзя пользоваться функциями valueOf() и new Integer и тд
     */
    public static Number valueOf(String str) {

        if (str == null || str == "") {
            return null;
        }
        String[] strCopy = new String[str.length()];
        String strAnswer = "";
        String[] allowedSymbols = {"e", ".", "-"};
        int[] ammountOfAllowedSybols = new int[3];

        for (int i = 0; i < str.length(); i++) {
            strCopy[i] = String.valueOf(str.charAt(i));
        }

        for (int i = 0; i < str.length(); i++) {
            if (strCopy[i].matches("[-e.]*[0-9]*")) {
                strAnswer += str.charAt(i);
            }
        }
        long longAnswer = 0;
        double doubleAnswer = 0;
        int intAnswer = 0;
        if (strAnswer.matches("-?[0-9]+")) {
            if (strAnswer.matches("-?[0-9]+\\.[0-9]+")) {
                if (strAnswer.matches("-?([0-9]+\\.[0-9]+|[0-9]+)e-?[0-9]+")) {
                    return Double.valueOf(strAnswer);
                }
                return null;
            }

            return null;
        }
        return null;

//        if ((Long.valueOf(strAnswer) > Integer.MAX_VALUE) || (Long.valueOf(strAnswer) < Integer.MIN_VALUE)) {
//            return Long.valueOf(strAnswer);
//        }

//        if (strAnswer.indexOf('e') != -1) {
//            String[] strExp = strAnswer.split("e");
//        }
    }





}
