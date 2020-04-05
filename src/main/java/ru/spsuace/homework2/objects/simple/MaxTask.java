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
        int n = array.length;

        if (n < count) {
            return null;
        }
        if (count == 0) {
            return new int[]{};
        }

        int[] sortArray = new int[count];

        int[] newArray = new int[n];
        System.arraycopy(array, 0, newArray, 0, n);
        Arrays.sort(newArray);
        int j = 0;
        for (int i = n - 1; i >= 0; i--) {
            sortArray[j] = newArray[i];
            if (j == count - 1) {
                return sortArray;
            }
            j++;
        }
        return sortArray;
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
        int n = array.length;

        if (n < count) {
            return null;
        }
        if (count == 0) {
            return new int[]{};
        }

        int[] sortArray = new int[count];

        int[] newArray = new int[n];
        int maxValueIndex = 0;
        System.arraycopy(array, 0, newArray, 0, n);
        for (int i = 0; i <= count - 1; i++) {
            int maxValue = Integer.MIN_VALUE;
            for (int j = 0; j <= n - 1; j++) {
                if (newArray[j] > maxValue) {
                    maxValue = newArray[j];
                    maxValueIndex = j;
                }
            }
            sortArray[i] = maxValue;
            newArray[maxValueIndex] = Integer.MIN_VALUE;
        }
        return sortArray;
    }

}
