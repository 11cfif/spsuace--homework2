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
        if (array == null || array.length < count) {
            return null;
        } else {
            int newArray[] = new int[count];
            Arrays.sort(array);
            for (int i = 0; i < count; i++) {
                newArray[i] = array[array.length - i - 1];
            }
            return newArray;
        }

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
        if (array == null || array.length < count) {
            return null;
        } else {
            int newArray[] = new int[count];
            for (int j = 0; j < count; j++) {
                int shortArray[] = new int[array.length - 1];
                int max = array[0];
                for (int i = 0; i < array.length; i++) {
                    if (array[i] > max) {
                        max = array[i];
                    }
                }
                int k = 0;
                boolean b = true;
                for (int i = 0; i < shortArray.length; i++) {
                    if (array[i] == max && b) {
                        k++;
                        b = false;
                    }
                    shortArray[i] = array[k];
                    k++;
                }
                array = shortArray;
                newArray[j] = max;
            }
            return newArray;
        }

    }

}
