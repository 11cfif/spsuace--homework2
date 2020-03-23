package ru.spsuace.homework2.objects.simple;

import java.util.Arrays;

public class MaxTask {

    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если длина массива меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     */
    public static int[] getMaxArraySimple(int[] array, int count) {
        int[] tempArray = Arrays.copyOf(array, array.length);

        if (tempArray.length < count) {
            return null;
        }
        int[] finalArray = new int[count];
        if (count == 0) {
            return finalArray;
        }
        Arrays.sort(tempArray);
        for (int i = 0; i < count; i++) {
            finalArray[i] = tempArray[tempArray.length - i - 1];
        }
        return finalArray;
    }
