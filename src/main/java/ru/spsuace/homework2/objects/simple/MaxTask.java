package ru.spsuace.homework2.objects.simple;

import java.util.Arrays;
import java.util.Collections;

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

        int[] result = new int[count];

        if (count == 0) {
            return result;
        }

        int[] updatedArray = Arrays.copyOf(array, array.length);

        Arrays.sort(updatedArray);

        for (int i = 0; i < count; i++) {
            result[i] = updatedArray[updatedArray.length - i - 1];
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
        if (array.length < count) {
            return null;
        }

        int[] result = new int[count];

        if (count == 0) {
            return result;
        }

        int[] updatedArray = Arrays.copyOf(array, array.length);
        int maxNumber = updatedArray[0];
        int temporarilyValue = 0;

        for (int i = 0; i < count; i++) {
            for (int j = 1; j < updatedArray.length; j++) {
                if (updatedArray[j] > maxNumber) {
                    maxNumber = updatedArray[j];
                    temporarilyValue = j;
                }
            }

            result[i] = maxNumber;
            updatedArray[temporarilyValue] = Integer.MIN_VALUE;
            maxNumber = updatedArray[0];
        }

        return result;
    }
}
