package ru.spsuace.homework2.collections;

import java.util.Set;
import java.util.HashSet;

/**
 * Реализуйте симметричную разность двух множеств: https://ru.wikipedia.org/wiki/Симметрическая_разность
 * Исходные множества модифицировать нельзя.
 * Пример: {1, 2, 3} и {0, 1, 2} -> {0, 3}.
 *
 */
public class SymmetricDifference {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        HashSet<T> symmetricDifference = new HashSet<>(set1);
        symmetricDifference.addAll(set2);
        HashSet<T> tmp = new HashSet<T>(set1);
        tmp.retainAll(set2);
        symmetricDifference.removeAll(tmp);
        return symmetricDifference;
    }
}
