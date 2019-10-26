package ru.spsuace.homework2.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * Реализуйте симметричную разность двух множеств: https://ru.wikipedia.org/wiki/Симметрическая_разность
 * Исходные множества модифицировать нельзя.
 * Пример: {1, 2, 3} и {0, 1, 2} -> {0, 3}.
 *
 */
public class SymmetricDifference {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        HashSet<T> set1Unique = new HashSet<>(set1);
        HashSet<T> set2Unique = new HashSet<>(set2);
        set1Unique.removeAll(set2);
        set2Unique.removeAll(set1);
        set1Unique.addAll(set2Unique);
        return set1Unique;
    }
}
