package ru.spsuace.homework2.objects.october2;

public class MaxTask {
    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если длина массива меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     */
    public static int[] getMaxArray(int[] array, int count) {
        if (array.length < count) {
            return null;
        }
        int[] massMax;
        massMax = new int[count];
        int last = array.length;
        for (boolean sorted = last == 0; !sorted; --last) {
            sorted = true;
            for (int i = 1; i < last; ++i) {
                if (array[i - 1] < array[i]) {
                    sorted = false;
                    int tmp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = tmp;
                }
            }
        }
        for (int j = 0; j < count; j++) {
            massMax[j] = array[j];
        }
        return massMax;
    }

}
