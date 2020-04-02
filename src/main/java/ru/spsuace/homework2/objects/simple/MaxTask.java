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

        Arrays.sort(array);

        int[] result = new int[count];
        int arrayLength = array.length;
        for (int i = arrayLength - 1, n = 0; i >= arrayLength - count; i--, n++) {
            result[n] = array[i];
        }

        return result;
    }

    public static void main(String[] arg) {
        System.out.println(Arrays.toString(MaxTask.getMaxArrayHard(new int[]{1, 3, 10, 11, 22, 0}, 2)));
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

        int[] result = new int[count];
        int arrayLength = array.length;

        for (int n = 0; n < count; n++) {
            int maxIndex = 0;
            int max = array[0];

            for (int i = 0; i < arrayLength; i++) {
                if (array[i] > max) {
                    max = array[i];
                    maxIndex = i;
                }
            }

            array[maxIndex] = array[arrayLength - 1];
            result[n] = max;
            arrayLength--;
        }

        return result;
    }

}
