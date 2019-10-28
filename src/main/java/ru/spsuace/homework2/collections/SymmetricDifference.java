package ru.spsuace.homework2.collections;


import java.util.Set;
import java.util.HashSet;

/**
 * Реализуйте симметричную разность двух множеств: https://ru.wikipedia.org/wiki/Симметрическая_разность
 * Исходные множества модифицировать нельзя.
 * Пример: {1, 2, 3} и {0, 1, 2} -> {0, 3}.
 */
public class SymmetricDifference {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set answer = new HashSet<>();
        Set set1Copy = new HashSet<>(set1);
        Set set2Copy = new HashSet<>(set2);
        set1Copy.addAll(set1);
        set2Copy.addAll(set2);

        answer.addAll(set2Copy);
        return answer;
    }
}
