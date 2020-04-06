package ru.spsuace.homework2.objects.simple;

import java.util.Arrays;

public class MaxTask {

    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если длина массива меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     * Можно пользоваться Arrays.sort(arr), эта функция сортирует входящий массив
     *
     */
    public static int[] getMaxArraySimple(int[] array, int count) {
        if (count > array.length) {
            return null;
        }
        int[] temparray = Arrays.copyOf(array, array.length);
        Arrays.sort(temparray);
        int endofarray = temparray.length - 1;
        int[] finishedarray = new int[count];
        for (int i = 0; i <= count - 1; i++) {
            finishedarray[i] = temparray[endofarray];
            endofarray -= 1;
        }
        return finishedarray;
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
        int[] finishedarray = new int[count];
        int[] temparray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < count; i++) {
            int max = temparray[0];
            for (int k = 0; k < temparray.length; k++) {
                max = Math.max(max, temparray[k]);
            }
            finishedarray[i]=max;
            for (int j = 0; ; j++) {
                if (max == temparray[j]) {
                    temparray[j] = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        return finishedarray;
    }
}
