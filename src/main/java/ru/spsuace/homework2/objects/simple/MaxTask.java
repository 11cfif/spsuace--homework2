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


    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если длина массива меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     * Сделать надо без ПОЛНОЙ сортировки массива array
     *
     */
    public static int[] getMaxArrayHard(int[] array, int count) {
        if (array.length < count) {
            return null;
        }
        for (int l = 0; l < array.length; l++) {
            int min = array[l];
            int min1 = l;
            for (int j = l + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    min1 = j;
                }
            }
            int t = array[l];
            array[l] = min;
            array[min1] = t;
        }
        int i = 0;
        int[] array1;
        array1 = new int[count];
        for (int n = (array.length - 1); n >= (array.length - count); n--) {
            if (count == 0) {
                array1 = new int[0];
                return array1;
            }
            array1[i] = array[n];
            i++;
        }
        return array1;
    }
}
