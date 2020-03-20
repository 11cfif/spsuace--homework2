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
        int[] array1 = array;
        Arrays.sort(array1);
        if (count > array1.length) {
            return null;
        }
        int lastElement = array1.length - 1;
        int[] array2 = new int[count];
        for (int i = 0; i <= count - 1; i++) {
            array2[i] = array1[lastElement];
            lastElement -= 1;
        }
        return array2;
    }
}
