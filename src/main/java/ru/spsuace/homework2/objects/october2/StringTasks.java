package ru.spsuace.homework2.objects.october2;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

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

        char[] strCopy = new char[str.length()];
        char[] strAnswerCopy = new char[str.length()];
        String strAnswer = "";
        char[] allowedSymbols = {'e', '.', '-'};
        int[] ammountOfAllowedSybols = new int[3];

        for (int i = 0; i < str.length(); i++) {
            strCopy[i] = str.charAt(i);
        }
        for (int i = 1; i < str.length(); i++) {
            if (strCopy[i-1] == allowedSymbols[2] && strCopy[i] == allowedSymbols[0]){
                return null;
            }
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
            if ((ammountOfAllowedSybols[2] > 1) && (ammountOfAllowedSybols[0] == 1) &&
                    (str.indexOf(allowedSymbols[0]) < str.indexOf(allowedSymbols[2]))) {
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
        if (strAnswer.charAt(strAnswer.length() - 1) == '-') {
            return null;
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
     * Дополнительно задание
     * Тоже самое, что и выше, но нельзя пользоваться функциями valueOf() и new Integer и тд
     */
    public static Number valueOf(String str) {

        if (str == null || str == "") {
            return null;
        }
        char[] strCopy = new char[str.length()];
        String strAnswer = "";
        char[] allowedSymbols = {'e', '.', '-'};
        int[] ammountOfAllowedSymbols = new int[3];
        for (int i = 0; i < str.length(); i++) {
            strCopy[i] = str.charAt(i);
        }
        for (int i = 1; i < str.length(); i++) {
            if (strCopy[i-1] == allowedSymbols[2] && strCopy[i] == allowedSymbols[0]){
                return null;
            }
        }
        for (char element : strCopy) {
            for (int i = 0; i < 3; i++) {
                if (element == allowedSymbols[i]) {
                    ammountOfAllowedSymbols[i]++;
                }
            }
            if (((ammountOfAllowedSymbols[2] > 1) && (ammountOfAllowedSymbols[0] == 0)) ||
                    ((ammountOfAllowedSymbols[2] > 2) && (ammountOfAllowedSymbols[0] == 1))) {
                return null;
            }
            if ((ammountOfAllowedSymbols[2] > 1) && (ammountOfAllowedSymbols[0] == 1) &&
                    (str.indexOf(allowedSymbols[0]) < str.indexOf(allowedSymbols[2]))) {
                return null;
            }
        }
        for (int i = 0; i < 2; i++) {
            if (ammountOfAllowedSymbols[i] > 1) {
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
        if (strAnswer.charAt(strAnswer.length() - 1) == '-') {
            return null;
        }
//        if ((ammountOfAllowedSymbols[0] > 0) || (ammountOfAllowedSymbols[1] > 0)) {
//            return Double.valueOf(strAnswer);
//        }
//        if ((Long.valueOf(strAnswer) > Integer.MAX_VALUE) || (Long.valueOf(strAnswer) < Integer.MIN_VALUE)) {
//            return Long.valueOf(strAnswer);
//        }
//        return Integer.valueOf(strAnswer);

        //private static getDigit(char str1){ return }
        long answerLong = 0;

        double answerDouble = 0;

//        if (strAnswer.indexOf('e') != -1) {
//            String[] strExp = strAnswer.split("e");
//
//        }
        if (strAnswer.charAt(0) == '-'){

            if (strAnswer.indexOf('e') != -1){



                for (int i = 1; i < strAnswer.length(); i++){
                    answerLong = (int)Math.pow(10,strAnswer.length()-i) *
                            Character.digit(strAnswer.charAt(i),10);
                }
                answerLong *= -1;
            }
        }


        for (int i = 0; i < strAnswer.length(); i++){
            answerLong = (int)Math.pow(10,strAnswer.length()-i) *
                    Character.digit(strAnswer.charAt(i),10);
        }
        if (answerLong < Integer.MAX_VALUE || answerLong > Integer.MIN_VALUE){
            return (int)answerLong;
        }
        return null;

    }

   // private static int getDigit(char str1){ return Character.digit(str1, 10); }


}
