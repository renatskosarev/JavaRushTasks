package com.javarush.task.jdk13.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Максимальное и минимальное числа в массиве
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        int maximum = array[0];
        int minimum = array[0];



       for (int i = 0; i < array.length; i++) {
           if (array[i] > maximum) {
               maximum = array[i];
           } else {
               if (array[i] < minimum) {
                   minimum = array[i];
               }
           }
       }

        System.out.print(maximum + " " + minimum);
    }
}
