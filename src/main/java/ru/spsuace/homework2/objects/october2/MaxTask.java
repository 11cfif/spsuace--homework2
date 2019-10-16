package ru.spsuace.homework2.objects.october2;
import java.util.*;

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
        if(count>array.length){
            return null;
        }
        int result[] = new int[count];
        Arrays.sort(array);
        for (int i = 0; i < count; i++) {
            result[i]=array[array.length - i - 1];
        }

        return result;
    }

}
