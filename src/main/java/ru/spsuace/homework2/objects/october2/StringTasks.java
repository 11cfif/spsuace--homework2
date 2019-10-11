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
        if (str.isEmpty() || str == null) {
            return null;
        }
        int valT = 0;
        String res = "";
        int i;
        for (i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) || str.charAt(i) == '.' || str.charAt(i) == 'e' || str.charAt(i) == '-') {
                res = res + str.charAt(i);
            }
        }
        if (res.matches("-?[0-9]+")) {
            if (Long.valueOf(res) > Integer.MAX_VALUE || Long.valueOf(res) < Integer.MIN_VALUE) {
                return Long.valueOf(res);
            }
            return Integer.valueOf(res);
        }
        if (res.matches("-?[0-9]+\\.[0-9]")) {
            return Double.valueOf(res);
        }
        if (res.matches("-?[0-9]+e-?[0-9]+")) {
            return Double.valueOf(res);
        }
        if (res.matches("-?[0-9]+\\.[0-9]+e-?[0-9]+")) {
            return Double.valueOf(res);
        }

        return null;
    }

    /**
     * Тоже самое, что и выше, но нельзя пользоваться функциями valueOf()
     */
    public static Number valueOf(String str) {
        return null;
    }
}
