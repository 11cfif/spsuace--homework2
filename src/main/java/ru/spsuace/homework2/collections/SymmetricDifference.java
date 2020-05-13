package ru.spsuace.homework2.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * Реализуйте симметричную разность двух множеств: https://ru.wikipedia.org/wiki/Симметрическая_разность
 * Исходные множества модифицировать нельзя.
 * Пример: {1, 2, 3} и {0, 1, 2} -> {0, 3}.
 * <p>
 * 2 балла
 */
public class SymmetricDifference {
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> res1 = new HashSet<>(set1);
        Set<T> res2 = new HashSet<>(set2);
        res1.removeAll(set2);
        res2.removeAll(set1);
        res1.addAll(res2);
        return res1;
    }
}
