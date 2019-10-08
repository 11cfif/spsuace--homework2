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
        if (str == null || str.isEmpty()) {
            return null;
        }

        char maxChar = str.charAt(0);
        int maxRepeat = 1;

        int numberChar = 0;
        int nowCh = 0;
        int nowMaxRepeat = 0;

        while (nowCh + nowMaxRepeat < str.length() - 1) {
            nowCh = numberChar;
            nowMaxRepeat = 1;
            for (int nextCh = numberChar + 1; nextCh < str.length(); nextCh++) {
                if (str.charAt(nowCh) == str.charAt(nextCh)) {
                    nowMaxRepeat++;
                } else {
                    numberChar = nextCh;
                    break;
                }
            }
            if (nowMaxRepeat > maxRepeat) {
                maxChar = str.charAt(nowCh);
                maxRepeat = nowMaxRepeat;
            }
        }

        return new Pair<>(maxChar, maxRepeat);
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
