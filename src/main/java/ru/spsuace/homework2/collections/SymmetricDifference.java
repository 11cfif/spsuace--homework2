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
        Set<T> difference = new HashSet<>(set1);
        Set<T> temp = new HashSet<>(set2);

        difference.removeAll(set2); //delete all that includes set2
        temp.removeAll(set1); //delete all that includes set1
        difference.addAll(temp); //combine what's left

        return difference;
    }
}