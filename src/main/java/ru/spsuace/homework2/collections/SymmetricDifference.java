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
        Set<T> collectionResult = new HashSet<T>();
        if (set1.isEmpty()) {
            return (Set<T>) set2;
        }
        if (set2.isEmpty()) {
            return (Set<T>) set1;
        }
        if (set1.isEmpty() && set2.isEmpty()) {
            return collectionResult;
        }
        for (T currentElementSet1 : set1) {
            if (!set2.contains(currentElementSet1)) {
                collectionResult.add(currentElementSet1);
            }
        }
        for (T currentElementSet2 : set2) {
            if (!set1.contains(currentElementSet2)) {
                collectionResult.add(currentElementSet2);
            }
        }
        return collectionResult;
    }
}
