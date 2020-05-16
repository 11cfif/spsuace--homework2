package ru.spsuace.homework2.collections;

import java.util.Set;


/**
 * Реализуйте симметричную разность двух множеств: https://ru.wikipedia.org/wiki/Симметрическая_разность
 * Исходные множества модифицировать нельзя.
 * Пример: {1, 2, 3} и {0, 1, 2} -> {0, 3}.
 *
 */
public class SymmetricDifference {

    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> symmetricDifference = new HashSet<>(set1);
        Set<T> tempHash = new HashSet<>(set2);
        symmetricDifference.removeAll(set2);
        tempHash.removeAll(set1);
        symmetricDifference.addAll(tempHash);
        return symmetricDifference;
    }
}