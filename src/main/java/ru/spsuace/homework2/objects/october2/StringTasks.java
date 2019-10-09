package ru.spsuace.homework2.objects.october2;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class StringTasks {

    /**
     * Убрать все лишние символы из строки и вернуть получившееся число.
     * Разрешенные символы: цифры, '-', '.', 'e'
     * Если '.' и 'e' больше чем 1, возвращаем null
     * Любой класс-обертка над примитивами наследуется от Number
     * Можно использовать функции Double.valueOf() и другие такие же
     */
    public static Number simpleValueOf(String str) {

        if (str == null || str == "") {
            return null;
        }

        char[] strCopy = new char[str.length()];
        char[] strAnswerCopy = new char[str.length()];
        String strAnswer = "";
        char[] allowedSymbols = {'e', '.', '-'};
        int[] ammountOfAllowedSybols = new int[3];

        for (int i = 0; i < str.length(); i++) {
            strCopy[i] = str.charAt(i);
        }
        for (char element : strCopy) {
            for (int i = 0; i < 3; i++) {
                if (element == allowedSymbols[i]) {
                    ammountOfAllowedSybols[i]++;
                }
            }
            if (((ammountOfAllowedSybols[2] > 1) && (ammountOfAllowedSybols[0] == 0)) ||
                    ((ammountOfAllowedSybols[2] > 2) && (ammountOfAllowedSybols[0] == 1))) {
                return null;
            }
        }
        for (int i = 0; i < 2; i++) {
            if (ammountOfAllowedSybols[i] > 1) {
                return null;
            }
        }
        for (int i = 0; i < str.length(); i++) {

            if (!(strCopy[i] >= '0' && strCopy[i] <= '9')) {
                for (char element : allowedSymbols) {
                    if (element == strCopy[i]) {
                        strAnswer += str.charAt(i);
                    }
                }
            } else {
                str.charAt(i);
                strAnswer += str.charAt(i);
            }
        }

        if ((ammountOfAllowedSybols[0] > 0) || (ammountOfAllowedSybols[1] > 0)) {
            return Double.valueOf(strAnswer);
        }
        if ((Long.valueOf(strAnswer) > Integer.MAX_VALUE) || (Long.valueOf(strAnswer) < Integer.MIN_VALUE)) {
            return Long.valueOf(strAnswer);
        }
        return Integer.valueOf(strAnswer);
    }


    /**
     * Тоже самое, что и выше, но нельзя пользоваться функциями valueOf()
     */
    public static Number valueOf(String str) {

        if (str == null || str == "") {
            return null;
        }
        char[] strCopy = new char[str.length()];
        char[] strAnswerCopy = new char[str.length()];
        String strAnswer = "";
        char[] allowedSymbols = {'e', '.', '-'};
        int[] ammountOfAllowedSybols = new int[3];

        for (int i = 0; i < str.length(); i++) {
            strCopy[i] = str.charAt(i);
        }
        for (char element : strCopy) {
            for (int i = 0; i < 3; i++) {
                if (element == allowedSymbols[i]) {
                    ammountOfAllowedSybols[i]++;
                }
            }
            if (((ammountOfAllowedSybols[2] > 1) && (ammountOfAllowedSybols[0] == 0)) ||
                    ((ammountOfAllowedSybols[2] > 2) && (ammountOfAllowedSybols[0] == 1))) {
                return null;
            }
        }
        for (int i = 0; i < 2; i++) {
            if (ammountOfAllowedSybols[i] > 1) {
                return null;
            }
        }
        for (int i = 0; i < str.length(); i++) {

            if (!(strCopy[i] >= '0' && strCopy[i] <= '9')) {
                for (char element : allowedSymbols) {
                    if (element == strCopy[i]) {
                        strAnswer += str.charAt(i);
                    }
                }
            } else {
                str.charAt(i);
                strAnswer += str.charAt(i);
            }
        }




        return null;
    }
}
