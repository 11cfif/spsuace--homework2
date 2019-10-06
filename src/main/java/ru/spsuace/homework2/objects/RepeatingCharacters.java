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
        if (str == null || str == "") {
            return null;
        }
        char charMax = str.charAt(0);
        int maxRepeatingCharacters = 0;
        int repeatingCharacterCounter = 1;
        int length = str.length();
        for (int i = 0; i < length - 1; i++) {
            char previousSymbol = str.charAt(i);
            char nextSymbol = str.charAt(i + 1);
            if (previousSymbol != nextSymbol) {
                repeatingCharacterCounter = 1;
                continue;
            }
            if (previousSymbol == nextSymbol) {
                repeatingCharacterCounter += 1;
            }
            if (repeatingCharacterCounter > maxRepeatingCharacters){
                maxRepeatingCharacters = repeatingCharacterCounter;
                charMax = previousSymbol;
            }
        }
            return new Pair<>(charMax, maxRepeatingCharacters);
        }

    public static class Pair<T, V> {
        private final T first;
        private final V second;

        public Pair(T first, V second) {
            this.first = first;
            this.second = second;
        }

        public String toString() {
            return " " + getFirst() + ',' + getSecond();
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
