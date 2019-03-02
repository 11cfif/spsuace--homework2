package ru.spsuace.homework2.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.*;

public class SymmetricDifferenceTest {

    @Test
    public void symmetricDifference_empty() {
        Set<String> a = Collections.emptySet();
        Set<String> b = Collections.emptySet();
        assertEquals(Collections.emptySet(), SymmetricDifference.symmetricDifference(a, b));
        assertEquals(Collections.emptySet(), a);
        assertEquals(Collections.emptySet(), b);
    }

    @Test
    public void symmetricDifference_Simple() {
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> b = new HashSet<>(Arrays.asList(0, 1, 2));
        Set<Integer> c = new HashSet<>(Arrays.asList(0, 3));
        assertEquals(c, SymmetricDifference.symmetricDifference(a, b));
        assertEquals(new HashSet<>(Arrays.asList(1, 2, 3)), a);
        assertEquals(new HashSet<>(Arrays.asList(0, 1, 2)), b);
    }

    @Test
    public void symmetricDifference_Hard() {
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 6, 7, 9, 10));
        Set<Integer> b = new HashSet<>(Arrays.asList(3, 4, 6, 2, 10, 12));
        Set<Integer> c = new HashSet<>(Arrays.asList(1, 7, 9, 4, 12));
        assertEquals(c, SymmetricDifference.symmetricDifference(a, b));
        assertEquals(new HashSet<>(Arrays.asList(1, 2, 3, 6, 7, 9, 10)), a);
        assertEquals(new HashSet<>(Arrays.asList(3, 4, 6, 2, 10, 12)), b);
    }

    @Test
    public void symmetricDifference_firstEmpty() {
        Set<String> a = Collections.emptySet();
        Set<Integer> b = new HashSet<>(Arrays.asList(0, 1, 2));
        Set<Integer> c = new HashSet<>(Arrays.asList(0, 1, 2));

        assertEquals(new HashSet<>(Arrays.asList(0, 1, 2)), c);
        assertEquals(Collections.emptySet(), a);
        assertEquals(new HashSet<>(Arrays.asList(0, 1, 2)), b);
    }

    @Test
    public void symmetricDifference_secondEmpty() {
        Set<Integer> a = new HashSet<>(Arrays.asList(0, 1, 2));
        Set<String> b = Collections.emptySet();
        Set<Integer> c = new HashSet<>(Arrays.asList(0, 1, 2));

        assertEquals(new HashSet<>(Arrays.asList(0, 1, 2)), c);
        assertEquals(Collections.emptySet(), b);
        assertEquals(new HashSet<>(Arrays.asList(0, 1, 2)), a);
    }
}