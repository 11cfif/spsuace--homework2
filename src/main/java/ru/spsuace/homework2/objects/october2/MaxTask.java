package ru.spsuace.homework2.objects.october2;

import java.lang.reflect.Array;

public class MaxTask {

    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если длина массива меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     *
     */
    public static int[] getMaxArray(int[] array, int count) {

        int[] arrayCopy = array;
        int[] arrayForAnswer = new int[count];
        int currentMax = 0;
        int currentIndex = 0;
        for (int i = 0; i < count; i++) {

            for (int j = 0; j < arrayCopy.length; j++) {

                if (currentMax < arrayCopy[j]) {
                    currentMax = arrayCopy[j];
                    currentIndex = j;
                }
            }
            arrayForAnswer[i] = currentMax;
            Array.setInt(arrayCopy, currentIndex, 0);
            currentMax = 0;
        }
        if (count > array.length) {
            return null;
        }
        return arrayForAnswer;
    }
}
