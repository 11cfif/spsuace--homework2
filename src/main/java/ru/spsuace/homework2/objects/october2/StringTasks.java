package ru.spsuace.homework2.objects.october2;

public class StringTasks {

    /**
     * Убрать все лишние символы из строки и вернуть получившееся число.
     * Разрешенные символы: цифры, '-', '.', 'e'
     * Если '.' и 'e' больше чем 1, возвращаем null
     * Любой класс-обертка над примитивами наследуется от Number
     * Можно использовать функции Double.valueOf() и другие такие же
     */
    public static Number simpleValueOf(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        str = str.replaceAll("[^0-9.e-]", "");
        int countdot = 0;
        int counte = 0;
        int countmin = 0;
        char[] array = str.toCharArray();
        int length = array.length;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                countdot++;
            }
            if (str.charAt(i) == 'e') {
                counte++;
            }
            if (str.charAt(i) == '-') {
                countmin++;
            }
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] == '-' && array[i - 1] == '-') {
                return null;
            }
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 'e' && array[i - 1] == '-') {
                return null;
            }
        }
        if (str.charAt(str.length() - 1) == '-') {
            return null;
        }
        if (countdot > 1 || counte > 1) {
            return null;
        }
        if (countdot == 0 && counte == 0) {
            if (countmin <= 1) {
                Long strToLong = Long.valueOf(str);
                if ((strToLong > Integer.MAX_VALUE) || (strToLong < Integer.MIN_VALUE)) {
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

    /**
     * Тоже самое, что и выше, но нельзя пользоваться функциями valueOf()
     */
    public static Number valueOf(String str) {
        return null;
    }
}
