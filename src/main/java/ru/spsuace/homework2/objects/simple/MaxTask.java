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
        Arrays.sort(array);
        int[] result = new int[count];
        if (count == 0) {
            return new int[0];
        }
        if (count > array.length) {
            return null;
        }
        int j = 0;
        for (int i = array.length - 1; i >= array.length - count; i--) {
            result[j++] = array[i];
        }
        return result;
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
        int[] result1 = new int[count];
        if (count == 0) {
            return new int[0];
        }
        if (count > array.length) {
            return null;
        }
        boolean sorted = true;
        int buf = 0;
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                sorted = true;
                if (array[i] < array[i + 1]) {
                    buf = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buf;
                    buf = 0;
                }
            }
        }
        for (int i = 0; i < count; i++) {
            result1[i] = array[i];
        }
        return result1;

    }

}
