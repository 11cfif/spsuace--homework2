package ru.spsuace.homework2.objects.october2;

import java.util.regex.Pattern;

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

        if (str == null || str.isEmpty()){
            return null;
        }

        String resulString = "";
        int valueMinus = 0;
        int valueE = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-' || Character.isDigit(str.charAt(i)) || str.charAt(i) == 'e') {
                    resulString += str.charAt(i);
            }
        }

        for (int i = 0; i < resulString.length(); i++) {
            if (resulString.charAt(i) == '-'){
                valueMinus++;
            }
            if (valueMinus > 1){
                return null;
            }
            if (resulString.charAt(i) == 'e'){
                valueE++;
            }
            if (valueE > 1){
                return null;
            }

        }

        if (valueE == 1 ){
            return Float.valueOf(resulString) * (int) 1;
        }

        if (Long.valueOf(resulString) > Integer.MAX_VALUE || Long.valueOf(resulString) < Integer.MIN_VALUE){
            return Long.valueOf(resulString);
        }

        return Integer.valueOf(resulString);
    }


    /**
     * Дополнительно задание
     * Тоже самое, что и выше, но нельзя пользоваться функциями valueOf() и new Integer и тд
     */
    public static Number valueOf(String str) {
        return null;
    }
}
