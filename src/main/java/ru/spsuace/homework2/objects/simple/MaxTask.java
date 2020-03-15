package ru.spsuace.homework2.objects.simple;

import java.util.Arrays;
import java.util.Collections;

public class MaxTask {

    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если длина массива меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     */
    public static int[] getMaxArray(int[] array, int count) {
        if (array.length < count) {
            return null;
        }
        Arrays.sort(array);
        int i = 0;
        int[] array1;
        array1 = new int[count];
        for (int n = (array.length-1); n >= (array.length-count); n--) {
            if (count == 0) {
                array1 = new int[0];
                return array1;
            }
            array1[i] = array[n];
            i = i + 1;
        }
        return array1;
    }
}
