package ru.spsuace.homework2.objects.simple;

import java.util.Arrays;

public class MaxTask {

    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если длина массива меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     *
     */
    public static int[] getMaxArraySimple(int[] array, int count) {
        if (count > array.length) {
            return null;
        }
        int[] tmpArray = Arrays.copyOf(array, array.length);
        int lastElement = tmpArray.length - 1;
        int[] finArray = new int[count];
        Arrays.sort(tmpArray);
        for (int i = 0; i <= count - 1; i++) {
            finArray[i] = tmpArray[lastElement];
            lastElement -= 1;
        }
        return finArray;
    }
    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если длина массива меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     * Нельзя пользоваться Arrays.sort
     */

    public static int[] getMaxArrayHard(int[] array, int count) {
        if (count > array.length) {
            return null;
        }
        int[] tmpArray = Arrays.copyOf(array, array.length);
        int[] finArray = new int[count];
        int tmp2 = 0;
        for (int j = 0; j <= count - 1; j++) {
            int tmp = Integer.MIN_VALUE;
            for (int i = 0; i <= tmpArray.length - 1; i++) {
                if (tmpArray[i] > tmp) {
                    tmp = tmpArray[i];
                    tmp2 = i;
                }
            }
            finArray[j] = tmp;
            tmpArray[tmp2] = Integer.MIN_VALUE;
        }
        return finArray;
    }
}
