package ru.spsuace.homework2.objects.simple;

import org.junit.Test;

import ru.spsuace.homework2.objects.simple.MaxTask;

import static org.junit.Assert.*;

public class MaxTaskTest {

    @Test
    public void getMaxArraySimple() {
        assertArrayEquals(new int[] {}, MaxTask.getMaxArraySimple(new int[] {}, 0));
        assertArrayEquals(new int[] {}, MaxTask.getMaxArraySimple(new int[] {1, 2, 3}, 0));
        assertArrayEquals(null, MaxTask.getMaxArraySimple(new int[] {1, 2, 3}, 4));
        assertArrayEquals(new int[] {22, 11}, MaxTask.getMaxArraySimple(new int[] {1, 3, 10, 11, 22, 0}, 2));
        assertArrayEquals(new int[] {22, 22, 11}, MaxTask.getMaxArraySimple(new int[] {1, 3, 22, 11, 22, 0}, 3));
        assertArrayEquals(new int[] {3, 2, 1}, MaxTask.getMaxArraySimple(new int[] {1, 2, 3}, 3));
        assertArrayEquals(new int[] {10, 9, 8, 8}, MaxTask.getMaxArraySimple(new int[] {5, 7, 1, 8, 9, 1, 4, 5, 10, 2, 8, 3, 1}, 4));
        assertArrayEquals(new int[] {-1, -2, -3}, MaxTask.getMaxArraySimple(new int[] {-1, -2, -3}, 3));
        assertArrayEquals(new int[] {-1, -2, -3}, MaxTask.getMaxArraySimple(new int[] {-3, -2, -1}, 3));
    }

    @Test
    public void getMaxArrayHard() {
        assertArrayEquals(new int[] {}, MaxTask.getMaxArrayHard(new int[] {}, 0));
        assertArrayEquals(new int[] {}, MaxTask.getMaxArrayHard(new int[] {1, 2, 3}, 0));
        assertArrayEquals(null, MaxTask.getMaxArrayHard(new int[] {1, 2, 3}, 4));
        assertArrayEquals(new int[] {22, 11}, MaxTask.getMaxArrayHard(new int[] {1, 3, 10, 11, 22, 0}, 2));
        assertArrayEquals(new int[] {22, 22, 11}, MaxTask.getMaxArrayHard(new int[] {1, 3, 22, 11, 22, 0}, 3));
        assertArrayEquals(new int[] {3, 2, 1}, MaxTask.getMaxArrayHard(new int[] {1, 2, 3}, 3));
        assertArrayEquals(new int[] {-1, -2, -3}, MaxTask.getMaxArrayHard(new int[] {-1, -2, -3}, 3));
        assertArrayEquals(new int[] {-1, -2, -3}, MaxTask.getMaxArrayHard(new int[] {-3, -2, -1}, 3));
        assertArrayEquals(new int[] {10, 9, 8, 8}, MaxTask.getMaxArrayHard(new int[] {5, 7, 1, 8, 9, 1, 4, 5, 10, 2, 8, 3, 1}, 4));
    }
}