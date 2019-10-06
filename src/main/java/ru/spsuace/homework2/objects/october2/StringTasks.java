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

        if (str == null || str == "") {
            return null;
        }

        char[] strCopy = new char[str.length()];
        char[] strAnswerCopy = new char[str.length()];
        String strAnswer = "";
        char[] allowedSymbols = {'e', '-', '.'};
        int[] ammountOfAllowedSybols = new int[3];

        for (int i = 0; i < str.length(); i++) {
            strCopy[i] = str.charAt(i);
        }

        for (char element : strCopy) {
            for (int i = 0; i < 2; i++) {
                if (element == allowedSymbols[i]) {
                    ammountOfAllowedSybols[i]++;
                }
            }
        }

        for (int ammountOfAllowedSymb : ammountOfAllowedSybols) {
            if (ammountOfAllowedSymb > 1) {
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
        double test = 1e2;
        Number o;
        if (Float.valueOf(strAnswer) > Integer.MAX_VALUE) {
            return Float.valueOf(strAnswer) * (int) 1;
        }
        int currentIntAnswer = Integer.valueOf(strAnswer);
        if ((Double.valueOf(strAnswer) / currentIntAnswer) != 1) {
            return Float.valueOf(strAnswer);
        }
        return Integer.valueOf(strAnswer);
    }


    /**
     * Тоже самое, что и выше, но нельзя пользоваться функциями valueOf()
     */
    public static Number valueOf(String str) {
        return null;
    }
}
