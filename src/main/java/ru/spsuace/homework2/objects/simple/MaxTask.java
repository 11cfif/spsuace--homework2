package ru.spsuace.homework2.objects.simple;

import java.util.Arrays;

public class MaxTask {

    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если длина массива меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     */

    public static int[] getMaxArray(int[] array, int count) {
        Arrays.sort(array);
        if (count > array.length) {
            return null;
        }
        int lastElement = array.length - 1;
        int[] array1 = new int[count];
        for (int i = 0; i <= count - 1; i++) {
            array1[i] = array[lastElement];
            lastElement -= 1;
        }
        return array1;
    }
}
