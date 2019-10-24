package ru.spsuace.homework2.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * Реализуйте симметричную разность двух множеств: https://ru.wikipedia.org/wiki/Симметрическая_разность
 * Исходные множества модифицировать нельзя.
 * Пример: {1, 2, 3} и {0, 1, 2} -> {0, 3}.
 *
 */
public class SymmetricDifference {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

        HashSet<T> answer = new HashSet<>(set1);
        HashSet<T> removeSet =  new HashSet<>(set1);
        answer.addAll(set2);
        removeSet.retainAll(set2);
        answer.removeAll(removeSet);

        return answer;
    }
}
