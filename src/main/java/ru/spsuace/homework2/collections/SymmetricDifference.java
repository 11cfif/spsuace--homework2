package ru.spsuace.homework2.collections;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


///**
// * Реализуйте симметричную разность двух множеств: https://ru.wikipedia.org/wiki/Симметрическая_разность
// * Исходные множества модифицировать нельзя.
// * Пример: {1, 2, 3} и {0, 1, 2} -> {0, 3}.
// *
// */
//    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2)
public class SymmetricDifference {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

        Set<T> answer = new HashSet<>(Arrays.asList());
        Set<T> set1Copy = new HashSet<>(Arrays.asList());
        Set<T> set2Copy = new HashSet<>(Arrays.asList());
        set1Copy.addAll(set1);
        set2Copy.addAll(set2);
        for (T element : set1Copy) {
            if (!set2Copy.contains(element)) {
                answer.add(element);
            }
            if (set2Copy.contains(element)) {
                set2Copy.remove(element);
            }
        }
        answer.addAll(set2Copy);
        return answer;
    }
}
