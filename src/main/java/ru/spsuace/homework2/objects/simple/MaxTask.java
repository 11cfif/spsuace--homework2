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
        int[] arr;
        arr = new int[count];
        for (int k = (array.length-1); k>=(array.length-count); k--) {
            if (count == 0) {
                arr = new int[0];
                return arr;
            }
            arr[i] = array[k];
            i++;
        }
        return arr;
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
        for (int t = 0; t < array.length; t++) {
            int min = array[t];
            int min1 = t;
            for (int j = t+1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    min1 = j;
                }
            }
            int m = array[t];
            array[t] = min;
            array[min1] = m;
        }
        int i = 0;
        int[] arr;
        arr = new int[count];
        for (int k = (array.length-1); k>=(array.length-count); k--) {
            if (count == 0) {
                arr = new int[0];
                return arr;
            }
            arr[i] = array[k];
            i++;
        }
        return arr;
    }
}
