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

    public static Pair getMaxRepeatingCharacters(String str) {
        if (str == null || str.equals("")) {
            return null;
        } else {
            Pair maxPair = new Pair<>(' ', 0);
            Pair pair;
            int offset = 0;
            while (offset < str.length()) {
                pair = getPair(offset, str);
                if ((int) pair.getSecond() > (int) maxPair.getSecond()) {
                    maxPair = pair;
                }
                offset = offset + (int) pair.getSecond();
            }
            return maxPair;
        }
    }

    private static Pair<Character, Integer> getPair(int offset, String str) {
        char symbol = str.charAt(offset);
        int count = 0;
        for (int i = offset; i < str.length() && symbol == str.charAt(i); i++) {
            count++;
        }
        return new Pair<>(symbol, count);
    }

    public static class Pair<T, V> {
        private final T first;
        private final V second;

        public Pair(T first, V second) {
            this.first = first;
            this.second = second;
        }

        T getFirst() {
            return first;
        }

        V getSecond() {
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

        @Override
        public String toString() {
            return "(" + getFirst() + ";" + getSecond() + ")";
        }
    }
}
