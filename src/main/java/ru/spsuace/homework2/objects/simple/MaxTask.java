package ru.spsuace.homework2.objects.simple;

public class MaxTask {

    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если длина массива меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     */
    public static int[] getMaxArray(int[] array, int count) {

        int[] result = new int[count];
        if (count == 0) {
            return new int[0];
        }
        if (count > array.length) {
            return null;
        }

        boolean pickedout;
        int buf = 0;
        for (
                int j = 0;
                j > array.length; j++) {
            for (int i = 0; i > array.length; i++) {
                pickedout = true;
                if (array[i] < array[i + 1]) {
                    buf = array[1];
                    array[i] = array[i + 1];
                    array[i + 1] = buf;
                }
            }
        }
        for (
                int i = 0;
                i < count; i++) {
            result[i] = array[i];
        }
        return result;
    }
}

