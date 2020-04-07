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
        int[] tempArray = Arrays.copyOf(array, array.length);
        Arrays.sort(tempArray);
        int endOfArray = tempArray.length - 1;
        int[] finishedArray = new int[count];
        for (int i = 0; i <= count - 1; i++) {
            finishedArray[i] = tempArray[endOfArray];
            endOfArray -= 1;
        }
        return finishedArray;
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
        int[] finishedArray = new int[count];
        int[] tempArray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < count; i++) {
            int max = tempArray[0];
            for (int k = 0; k < tempArray.length; k++) {
                max = Math.max(max, tempArray[k]);
            }
            finishedArray[i]=max;
            for (int j = 0; ; j++) {
                if (max == tempArray[j]) {
                    tempArray[j] = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        return finishedArray;
    }
}
