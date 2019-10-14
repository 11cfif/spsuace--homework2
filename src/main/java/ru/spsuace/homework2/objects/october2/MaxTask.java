package ru.spsuace.homework2.objects.october2;

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

        if (array.length < count) {
            return null;
        }

        int chackMaxNum;
        int[] maxNumbers;
        maxNumbers = new int[count];

        if (count == 0) {
            return maxNumbers;
        }

        for (int i = 0; i < array.length; i++) {
            int positionMinNum = 0;
            chackMaxNum = array[i];
            for (int j = 1; j < count; j++) {
                if (maxNumbers[positionMinNum] > maxNumbers[j]) {
                    positionMinNum = j;
                }
            }
            if (chackMaxNum > maxNumbers[positionMinNum]) {
                maxNumbers[positionMinNum] = chackMaxNum;
            }
        }

        for (int i = 1; i < count; i++) {
            if (maxNumbers[i - 1] < maxNumbers[i]) {
                chackMaxNum = maxNumbers[i - 1];
                maxNumbers[i - 1] = maxNumbers[i];
                maxNumbers[i] = chackMaxNum;
                i = 0;
            }
        }
        return maxNumbers;
    }
}
