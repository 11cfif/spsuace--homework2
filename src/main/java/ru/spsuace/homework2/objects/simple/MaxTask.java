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
        int[] sortArray;
        if (n < count) {
            return null;
        } else if (count == 0) {
            return new int[]{};
        } else {
            int[] newArray = new int[n];
            System.arraycopy(array, 0, newArray, 0, n);
            Arrays.sort(newArray);
            sortArray = new int[count];
            int j = 0;
            for (int i = n - 1; i >= 0; i--) {
                sortArray[j] = newArray[i];
                if (j == count - 1) {
                    return sortArray;
                }
                j++;
            }
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
        int[] sortArray;
        if (n < count) {
            return null;
        } else if (count == 0) {
            return new int[]{};
        } else {
            int[] newArray = new int[n];
            System.arraycopy(array, 0, newArray, 0, n);
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (newArray[j] < newArray[j + 1]) {
                        k = newArray[j + 1];
                        newArray[j + 1] = newArray[j];
                        newArray[j] = k;
                    }
                }
            }
            sortArray = new int[count];
            System.arraycopy(newArray, 0, sortArray, 0, count);
        }
        return sortArray;
    }

}
