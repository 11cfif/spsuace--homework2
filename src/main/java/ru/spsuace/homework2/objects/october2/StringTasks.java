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
        int countDot = 0;
        int countE = 0;
        int countMin = 0;
        char[] array = str.toCharArray();
        int length = array.length;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                countDot++;
            }
            if (str.charAt(i) == 'e') {
                countE++;
            }
            if (str.charAt(i) == '-') {
                countMin++;
            }
        }
        if (countDot > 1 || countE > 1) {
            return null;
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
        if (countDot == 0 && countE == 0) {
            if (countMin <= 1) {
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
