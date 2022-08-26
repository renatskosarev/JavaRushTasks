package com.javarush.task.jdk13.task04.task0429;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Положительные и отрицательные числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[3];
        array[0] = Integer.parseInt(reader.readLine());
        array[1] = Integer.parseInt(reader.readLine());
        array[2] = Integer.parseInt(reader.readLine());
        
        int plusCounter = 0; int minusCounter = 0;
        for (int num : array) {
            if (num > 0) {
                plusCounter++;
            }
            if (num < 0) {
                minusCounter++;
            }
        }
        
        System.out.println("количество отрицательных чисел: " + minusCounter);
        System.out.println("количество положительных чисел: " + plusCounter);
    }
}
