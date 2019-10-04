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
        if ((str == null) || (str.isEmpty())) {
            return null;
        }

        char symbolFinal = str.charAt(0);
        char symbol = str.charAt(0);
        int maxSymbolRepeatFinal = 1;
        int maxSymbolRepeat = 1;

        for (int symbolPosition = 1; symbolPosition < str.length(); symbolPosition++) {
            if (symbol == str.charAt(symbolPosition)) {
                maxSymbolRepeat++;
            } else {
                maxSymbolRepeat = 1;
                symbol = str.charAt(symbolPosition);
            }

            if (maxSymbolRepeat > maxSymbolRepeatFinal) {
                maxSymbolRepeatFinal = maxSymbolRepeat;
                symbolFinal = symbol;
            }
        }
        return new Pair<>(symbolFinal, maxSymbolRepeatFinal);
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
