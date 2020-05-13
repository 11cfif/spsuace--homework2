package ru.spsuace.homework2.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
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
        Set<T> set = new HashSet<>();
        set.addAll(set1);
        set.addAll(set2);

        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            T item = it.next();
            if (set1.contains(item) && set2.contains(item)) {
                it.remove();
            }
        }

        return set;
    }

    public static void main(String[] args) {
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("1");
        set1.add("2");
        set1.add("3");

        Set<String> set2 = new LinkedHashSet<>();
        set2.add("0");
        set2.add("1");
        set2.add("2");

        System.out.println(symmetricDifference(set1, set2));
    }
}
