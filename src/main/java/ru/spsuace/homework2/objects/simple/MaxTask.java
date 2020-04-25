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
     */
    public static int[] getMaxArraySimple(int[] array, int count) {
        if (array.length < count) {
            return null;
        }
        Arrays.sort(array);
        int i = 0;
        int[] arr = new int[count];
        if (count == 0) {
            arr = new int[0];
            return arr;
        }
        for (int k = array.length - 1; k >= array.length - count; k--) {
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
     */
    public static int[] getMaxArrayHard(int[] array, int count) {
        if (array.length < count) {
            return null;
        }
        int[] arr = new int[count];
        for (int c = 0; c < count; c++) {
            int x;
            for (x = c; x < array.length - 2; x++) {
                arr[c] = array[x];
                if (array[x] <= array[x+1]) {
                    if (array[x+1] >= arr[c]) {
                        arr[c] = array[x+1];
                    }
                    arr[c] = arr[c];
                }
            }
            int i = 0;
            for(x = 0; x < array.length-1; x++) {
                if (array[x] == arr[c]) {
                    break;
                }
                array[x] = array[x];
                i = i + 1;
            }
            for (x = i; x < array.length-1; x++) {
                array[x] = array[x+1];
                i = i + 1;
            }
        }
        return arr;
    }
}
