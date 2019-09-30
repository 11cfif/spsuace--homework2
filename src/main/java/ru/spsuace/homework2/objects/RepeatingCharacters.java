package ru.spsuace.homework2.objects;


import java.util.Objects;

/**
 * Нужно найти символ, который встречается подряд в строке чаще всего, и указать количество повторений.
 * Если более одного символа с максимальным значением, то нужно вернуть тот символ,
 * который первый встречается в строчке
 * Если строка пустая или null, то вернуть null
 * Пример abbasbdlbdbfklsssbb -> (s, 4)
 */
public class RepeatingCharacters {

    public static Pair<Character, Integer> getMaxRepeatingCharacters(String str) {
        if (str.equals(null)){
            return null;
        } else {
            char letterMax = str.charAt(0);
            int numberMax = 0;
            for (int i = 0; i < str.length(); i++) {
                char letterCurrent = str.charAt(i);
                int numberCurrent = 1;
                for (int j = i; j < str.length(); j++) {
                    if (letterCurrent == str.charAt(j)) {
                        numberCurrent++;
                    }
                }
                if (numberCurrent > numberMax) {
                    numberMax = numberCurrent;
                    letterMax = letterCurrent;
                }
            }
            return new Pair<>(letterMax, numberMax);
        }
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
