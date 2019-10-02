package ru.spsuace.homework2.objects;


import java.util.Objects;

/**
 * Нужно найти символ, который встречается подряд в строке чаще всего, и указать количество повторений.
 * Если более одного символа с максимальным значением, то нужно вернуть тот символ,
 * который первый встречается в строчке
 * Если строка пустая или null, то вернуть null
 * Пример abbasbdlbdbfklsssbb -> (s, 3)
 */
public class RepeatingCharacters {

    public static Pair<Character, Integer> getMaxRepeatingCharacters(String str) {
        if (str.isEmpty() || str == null) {
            return null;
        }
        char letterMax = str.charAt(0);
        int numberMax = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            char letterCurrent = str.charAt(i);
            int numberCurrent = 0;
            int j = i;
            while (letterCurrent == str.charAt(j) && j < str.length() - 1) {
                numberCurrent++;
                j++;
                if (j == str.length() - 1 && numberCurrent != 1) {
                    numberCurrent++;
                }
            }
            if (numberCurrent > numberMax) {
                numberMax = numberCurrent;
                letterMax = letterCurrent;
            }
            i = j - 1;
        }
        return new Pair<>(letterMax, numberMax);

    }

    public static class Pair<T, V> {
        private final T first;
        private final V second;

        public Pair(T first, V second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

    }
}
