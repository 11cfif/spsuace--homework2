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
        int[] tmpArray1 = Arrays.copyOf(array, array.length);
        if (count > tmpArray1.length) {
            return null;
        }
        int lastElement = tmpArray1.length - 1;
        int[] tmpArray2 = new int[count];
        Arrays.sort(tmpArray1);
        for (int i = 0; i <= count - 1; i++) {
            tmpArray2[i] = tmpArray1[lastElement];
            lastElement -= 1;
        }
        return tmpArray2;
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
        int[] tmpArrayI = Arrays.copyOf(array, array.length);
        int[] tmpArrayII = new int[count];
        int tmp2 = 0;
        for (int j = 0; j <= count - 1; j++) {
            int tmp = Integer.MIN_VALUE;
            for (int i = 0; i <= tmpArrayI.length - 1; i++) {
                if (tmpArrayI[i] > tmp) {
                    tmp = tmpArrayI[i];
                    tmp2 = i;
                }
            }
            tmpArrayII[j] = tmp;
            tmpArrayI[tmp2] = Integer.MIN_VALUE;
        }
        return tmpArrayII;
    }
}
