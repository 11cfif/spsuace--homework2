package ru.spsuace.homework2.collections;

import java.util.Collections;
import java.util.Set;


/**
 * Реализуйте симметричную разность двух множеств: https://ru.wikipedia.org/wiki/Симметрическая_разность
 * Исходные множества модифицировать нельзя.
 * Пример: {1, 2, 3} и {0, 1, 2} -> {0, 3}.
 */
public class SymmetricDifference {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new java.util.HashSet<>(Collections.emptySet());
        for (T elementSet1 : set1) {
            boolean repeat = false;
            for (T elementSet2 : set2) {
                if (elementSet1 == elementSet2) {
                    repeat = true;
                    break;
                }
            }
            if (!repeat) {
                result.add(elementSet1);
            }
        }
        for (T elementSet2 : set2) {
            boolean repeat = false;
            for (T elementSet1 : set1) {
                if (elementSet2 == elementSet1) {
                    repeat = true;
                    break;
                }
            }
            if (!repeat) {
                result.add(elementSet2);
            }
        }
        return result;
    }
}
