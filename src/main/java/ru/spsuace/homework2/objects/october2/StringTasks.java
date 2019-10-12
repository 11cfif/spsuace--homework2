package ru.spsuace.homework2.objects.october2;

public class StringTasks {

    /**
     * Убрать все лишние символы из строки и вернуть получившееся число.
     * Разрешенные символы: цифры, '-', '.', 'e'
     * Если '.' и 'e' больше чем 1, возвращаем null
     * Любой класс-обертка над примитивами наследуется от Number
     * Можно использовать функции Double.valueOf() и другие такие же.
     *
     * Работайте со строкой, НЕ надо ее переводить в массив байт (это можно использовать только для цикла)
     * У класса Character есть полезные методы, например Character.isDigit()
     */
    public static Number simpleValueOf(String str) {
        String newStr = str;
        if (str == "" || str == null) {
            return null;
        }
        for (int Ch = 0; Ch < newStr.length(); Ch++) {
            if (!Character.isDigit(newStr.charAt(Ch)) && newStr.charAt(Ch) != 'e' && newStr.charAt(Ch) != '-' && newStr.charAt(Ch) != '.') {
                newStr = newStr.replace(newStr.charAt(Ch), ' ');
            }
        }
        newStr = newStr.replaceAll("\\s+", "");
        if (!newStr.matches("^[+-]?(\\d+\\.\\d+|\\d+\\.|\\.\\d+|\\d+)([eE][+-]?\\d+)?")) {
            return null;
        }
        if (newStr.indexOf('e') != -1 || newStr.indexOf('.') != -1) {
            return Double.parseDouble(newStr);
        } else if (Long.parseLong(newStr) > Integer.MAX_VALUE || Long.parseLong(newStr) < Integer.MIN_VALUE) {
            return Long.parseLong(newStr);
        } else {
            return Integer.parseInt(newStr);
        }
    }


    /**
     * Тоже самое, что и выше, но нельзя пользоваться функциями valueOf()
     */
    public static Number valueOf(String str) {
        if (str == "" || str == null) {
            return null;
        }
        String newStr = str.replaceAll("[^(-?\\d+|e)]", "");
        if (!newStr.matches("^[+-]?(\\d+\\.\\d+|\\d+\\.|\\.\\d+|\\d+)([eE][+-]?\\d+)?")) {
            return null;
        }
        if (newStr.indexOf('e') != -1 || newStr.indexOf('.') != -1) {
            return Double.parseDouble(newStr);
        } else if (Long.parseLong(newStr) > Integer.MAX_VALUE || Long.parseLong(newStr) < Integer.MIN_VALUE) {
            return Long.parseLong(newStr);
        } else {
            return Integer.parseInt(newStr);
        }
    }
}
