package ru.spsuace.homework2.objects.october2;

//import org.graalvm.compiler.lir.StandardOp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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

        int[] arrayCopy = new int[array.length];
        int[] arrayForAnswer = new int[count];
        for (int i = 0; i < array.length; i++) {
            arrayCopy[i] = array[i];
        }
        if (count > array.length) {
            return null;
        }
        Arrays.sort(arrayCopy, 0, arrayCopy.length);
        for (int i = 0; i < count; i++) {
            arrayForAnswer[i] = arrayCopy[arrayCopy.length - i - 1];
        }
        return arrayForAnswer;
    }
}
