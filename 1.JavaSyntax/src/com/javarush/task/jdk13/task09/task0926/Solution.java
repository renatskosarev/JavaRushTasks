package com.javarush.task.jdk13.task09.task0926;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Список из массивов чисел
*/

public class Solution {

    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> result = new ArrayList<>();
        result.add(new int[5]);
        result.add(new int[2]);
        result.add(new int[4]);
        result.add(new int[7]);
        result.add(new int[0]);
        return result;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            System.out.println(Arrays.toString(array));
        }
    }
}
