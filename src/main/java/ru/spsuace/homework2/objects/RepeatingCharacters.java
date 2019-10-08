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

        for (int nowCh = 0; nowCh < str.length(); nowCh++) {
            int nowMax = 0;
            for (int nowNextCh = nowCh; nowNextCh < str.length(); nowNextCh++) {
                if (str.charAt(nowCh) == str.charAt(nowNextCh)) {
                    nowMax++;
                } else {
                    break;
                }
            }
            if (nowMax > maxRepeat) {
                maxChar = str.charAt(nowCh);
                maxRepeat = nowMax;
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
