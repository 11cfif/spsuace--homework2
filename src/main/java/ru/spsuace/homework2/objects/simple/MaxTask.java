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
        if (count <= 0) {
            return new int[0];
        } else if (array.length < count) {
            return null;
        }

        int[] copyArray = Arrays.copyOf(array, array.length);
        Arrays.sort(copyArray);
        int[] result = new int[count];

        for (int i = copyArray.length - 1, n = 0; i >= copyArray.length - count; i--, n++) {
            result[n] = copyArray[i];
        }

        return result;
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
        if (count <= 0) {
            return new int[0];
        } else if (array.length < count) {
            return null;
        }

        int[] copyArray = Arrays.copyOf(array, array.length);
        int[] result = new int[count];
        int arrayLength = copyArray.length;

        for (int n = 0; n < count; n++) {
            int maxIndex = 0;
            int max = copyArray[0];

            for (int i = 0; i < arrayLength; i++) {
                if (copyArray[i] > max) {
                    max = copyArray[i];
                    maxIndex = i;
                }
            }

            copyArray[maxIndex] = copyArray[arrayLength - 1];
            result[n] = max;
            arrayLength--;
        }

        return result;
    }

}
