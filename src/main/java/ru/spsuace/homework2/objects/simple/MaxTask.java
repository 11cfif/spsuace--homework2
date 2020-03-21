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
        int[] arrayTemp =Arrays.copyOf(array,array.length);
        Arrays.sort(arrayTemp);
        int[] arrayFinal = new int[count];
        if (count == 0) {
            return arrayFinal;
        }
        for (int i = 0; i < count; i++) {
            arrayFinal[i] = arrayTemp[arrayTemp.length - i - 1];
        }
        return arrayFinal;
    }

    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если длина массива меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     * Нельзя пользоваться Arrays.sort
     *
     */
    public static int[] getMaxArrayHard(int[] array, int count) {
        if (array.length < count) {
            return null;
        }
        int[] arrayTemp = Arrays.copyOf(array, array.length);

        int[] arrayFinal = new int[count];
        if (count == 0) {
            return arrayFinal;
        }
        int max = arrayTemp[0];
        int indexMax = 0;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < arrayTemp.length; j++) {
                if (max < arrayTemp[j]) {
                    max = arrayTemp[j];
                    indexMax = j;
                }
            }
            arrayFinal[i] = max;
            max = arrayTemp[0];
            arrayTemp[indexMax] = Integer.MIN_VALUE;
        }
        return arrayFinal;
    }

}
