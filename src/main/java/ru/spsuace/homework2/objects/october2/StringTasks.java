package ru.spsuace.homework2.objects.october2;

public class StringTasks {

    /**
     * Убрать все лишние символы из строки и вернуть получившееся число.
     * Разрешенные символы: цифры, '-', '.', 'e'
     * Если '.' и 'e' больше чем 1, возвращаем null
     * Любой класс-обертка над примитивами наследуется от Number
     * Можно использовать функции Double.valueOf() и другие такие же
     * @return
     */

    public static Number simpleValueOf(String str) {
        if (str == null || str.isEmpty()){
            return null;
        }
        String newStr = str.replaceAll("[^[0-9]^e//.//-]","");
        if (!newStr.matches("^[-+]?[0-9]*[.]?[0-9]+(?:[e][-+]?[0-9]+)?$")){
            return null;
        }
        if (newStr.contains("e") || newStr.contains(".")){
            return Double.valueOf(newStr);
        } else if (Long.parseLong(newStr) > Integer.MAX_VALUE || Long.parseLong(newStr) < Integer.MIN_VALUE) {
            return Long.valueOf(newStr);
        }
        return Integer.valueOf(newStr);
    }


    /**
     * Тоже самое, что и выше, но нельзя пользоваться функциями valueOf()
     */
    public static Number valueOf(String str) {
        if (str == null || str.isEmpty()){
            return null;
        }
        String newStr = str.replaceAll("[^[0-9]^e//.//-]","");
        if (!newStr.matches("^[-+]?[0-9]*[.]?[0-9]+(?:[e][-+]?[0-9]+)?$")){
            return null;
        }
        if (newStr.contains("e") || newStr.contains(".")){
            int compos =1;
            return Double.parseDouble(newStr);
        } else if (Long.parseLong(newStr) > Integer.MAX_VALUE || Long.parseLong(newStr) < Integer.MIN_VALUE) {
            return Long.parseLong(newStr);
        }
        return Integer.parseInt(newStr);
    }

}
