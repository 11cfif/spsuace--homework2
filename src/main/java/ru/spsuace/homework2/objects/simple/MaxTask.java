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
        Arrays.sort(array);
        int EndOfArray = array.length - 1;
        int[] FinishedArray = new int[count];
        for (int i = 0; i <= count - 1; i++) {
            FinishedArray[i] = array[EndOfArray];
            EndOfArray -= 1;
        }
        return FinishedArray;
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
        int[] FinishedArray = new int[count];
        int[] tempArray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < count; i++) {
            int max = tempArray[0];
            for (int k = 0; k < tempArray.length; k++) {
                max = Math.max(max, tempArray[k]);
            }
            FinishedArray[i]=max;
            for (int j = 0; ; j++) {
                if (max == tempArray[j]) {
                    tempArray[j] = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        return FinishedArray;
    }
}
