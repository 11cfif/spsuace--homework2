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
        int[] result = new int[count];
        if (count == 0) {
            return new int[0];
        }
        if (count > array.length) {
            return null;
        }
        int[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);
        int j = 0;
        for (int i = array.length - 1; i >= array.length - count; i--) {
            result[j++] = copy[i];
        }
        return result;
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
        if (count == 0) {
            return new int[0];
        }
        if (count > array.length) {
            return null;
        }
        int[] result1 = new int[count];
        int[] copyArray = Arrays.copyOf(array, array.length);
        int buf = 0;
        for (int j = 0; j < count; j++) {
            int var = Integer.MIN_VALUE;
            for (int i = 0; i < copyArray.length; i++) {
                if (copyArray[i] > var) {
                    var = copyArray[i];
                    buf = i;
                }
            }
            result1[j] = var;
            copyArray[buf] = Integer.MIN_VALUE;
        }
        return result1;
    }

}
