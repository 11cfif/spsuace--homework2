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

        if (str == null || str.isEmpty()) {
            return null;
    }
        int number = 1;
        int max = 0;
        char s = 0;
        char[] array = str.toCharArray();

        for (int i = 1; array.length > i; i++) {
            if (array[i] == array[i - 1]) {
                number++;
            } else {
                number = 1;
            }
        }

        if (number > max) {
            max = number;
            s = array[array.length - 1];
        }
        return new Pair<>(s, max);
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
