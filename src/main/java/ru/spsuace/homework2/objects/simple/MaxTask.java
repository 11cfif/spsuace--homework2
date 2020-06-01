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
        if (count > array.length) {
            return null;
        }
        int[] tempArr = Arrays.copyOf(array, array.length);
        Arrays.sort(tempArr);
        int endOfArray = tempArr.length - 1;
        int[] finalArray = new int[count];
        for (int i = 0; i < count; i++) {
            finalArray[i] = tempArr[endOfArray];
            endOfArray -= 1;
        }
        return finalArray;
    }


    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если длина массива меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     * Сделать надо без ПОЛНОЙ сортировки массива array
     */
    public static int[] getMaxArrayHard(int[] array, int count) {
        if (count > array.length) {
            return null;
        }
        int[] newArray = new int[count];
        int[] extraArray = Arrays.copyOf(array, array.length);
        int elementNumb = 0;
        for (int j = 0; j < count; j++) {
            int var = Integer.MIN_VALUE;
            for (int i = 0; i < extraArray.length; i++) {
                if (extraArray[i] > var) {
                    var = extraArray[i];
                    elementNumb = i;
                }
            }
            newArray[j] = var;
            extraArray[elementNumb] = Integer.MIN_VALUE;
        }
        return newArray;
    }
}
