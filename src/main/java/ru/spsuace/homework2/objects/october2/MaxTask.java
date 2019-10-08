package ru.spsuace.homework2.objects.october2;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
        for (int i = 0; i < array.length; i++){
            arrayCopy[i] = array[i];
        }
        ArrayList<Integer> maxList = new ArrayList<>(0);

        int currentMax = 0;
        int currentIndex = 0;
        int buffer = 0;
        if (count > array.length) {
            return null;
        }
        //for (int i = 0; i < count; i++) {
            for (int j = 1; j < arrayCopy.length; j++) {

                if (currentMax < arrayCopy[j]) {
                    currentMax = arrayCopy[j];
                    maxList.add(currentMax);
                    currentIndex = j;
                }
//                if(arrayCopy[j-1] > arrayCopy[j]){
//                    buffer = arrayCopy[j-1];
//                    arrayCopy[j-1] = arrayCopy[j];
//                    arrayCopy[j-1] = buffer;
//                }

            }
            //arrayForAnswer[i] = currentMax;
            arrayCopy[currentIndex] = 0;
            currentMax = 0;

        //}





        return arrayForAnswer;
    }
}
