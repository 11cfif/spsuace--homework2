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
        int[] maxArray = new int[count];
        if (count == 0){
            return maxArray;
        }

            for (int i = 0; i < array.length; i++) {
                int maxElement = array[i];
                int maxNumber = i;
                for (int j = i + 1; j < array.length; j++) {
                    if (maxElement < array[j]) {
                        maxElement = array[j];
                        maxNumber = j;
                    }
                }
                if (i != maxNumber) {
                    int temporary = array[i];
                    array[i] = array[maxNumber];
                    array[maxNumber] = temporary;
                }
            }
        for (int i = 0; i < count; i++) {
            maxArray[i] = array[i];
        }
        return maxArray;
    }
}
