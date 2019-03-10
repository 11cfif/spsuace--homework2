package ru.spsuace.homework2.collections;

import java.util.HashSet;
import java.util.Set;


/**
 * Реализуйте симметричную разность двух множеств: https://ru.wikipedia.org/wiki/Симметрическая_разность
 * Исходные множества модифицировать нельзя.
 * Пример: {1, 2, 3} и {0, 1, 2} -> {0, 3}.
 */
public class SymmetricDifference {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

        Set<T> set3 = new HashSet<>(set1);
        Set<T> set4 = new HashSet<>(set2);
        set3.removeAll(set2);
        set4.removeAll(set1);
        set3.addAll(set4);
        return set3;
    }
}
