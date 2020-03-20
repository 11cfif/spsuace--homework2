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
        int[] tempArray = array;
        Arrays.sort(tempArray);
        if (count > tempArray.length) {
            return null;
        }
        int lastElement = tempArray.length - 1;
        int[] formattedArray = new int[count];
        for (int i = 0; i <= count - 1; i++) {
            formattedArray[i] = tempArray[lastElement];
            lastElement -= 1;
        }
        return formattedArray;
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
        if (array.length < count) {
            return null;
        }
        int[] tempArray = array;
        int temp = 0;
        for (int i = 0; i < tempArray.length; i++) {
            for (int j = i; j > 0; j--) {
                if (tempArray[j] > tempArray[j - 1]) {
                    temp = tempArray[j];
                    tempArray[j] = tempArray[j - 1];
                    tempArray[j - 1] = temp;
                }
            }
        }
        int[] formattedArray = new int[count];
        if (count == 0) {
            return formattedArray;
        }
        for (int i = 0; i < count; i++) {
            formattedArray[i] = tempArray[i];
        }
        return formattedArray;
    }
}

