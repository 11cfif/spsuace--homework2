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
        HashSet<T> collectionResult = new HashSet<>(set2);
        HashSet<T> collectionRemove = new HashSet<>(set2);
        collectionResult.addAll(set1);
        collectionRemove.retainAll(set1);
        collectionResult.removeAll(collectionRemove);

        return collectionResult;
    }
}

