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
        int[] arrayTemp = array;
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
        int[] arrayTemp = array;
        int temp = 0;
        for (int i = 0; i < arrayTemp.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arrayTemp[j] > arrayTemp[j - 1]) {
                    temp = arrayTemp[j];
                    arrayTemp[j] = arrayTemp[j - 1];
                    arrayTemp[j - 1] = temp;
                }
            }
        }
        int[] arrayFinal = new int[count];
        if (count ==0) {
            return arrayFinal;
        }
        for (int i = 0; i < count; i++) {
            arrayFinal[i] = arrayTemp[i];
        }
        return arrayFinal;
    }

}
