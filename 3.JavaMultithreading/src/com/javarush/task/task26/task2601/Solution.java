package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
        Integer[] array = new Integer[] {13, 8, 15, 5, 17};
        System.out.println(Arrays.toString(sort(array)));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int median;
                if (array.length % 2 == 0)
                    median = (array[array.length/2] + array[array.length/2 - 1])/2;
                else
                    median = array[array.length/2];


                return - ((Math.abs(o1 - median)) - (Math.abs(o2 - median)));
            }
        };

        Arrays.sort(array, comparator);
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[array.length - 1 - i];
        }
        return result;
    }


}
