package com.javarush.task.jdk13.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[20];
        for (int i = 0; i < 20; i++) {
            list[i] = Integer.parseInt(reader.readLine());
        }
        int[] sublist1 = new int[10];
        int[] sublist2 = new int[10];
        for (int i = 0; i < 10; i++) {
            sublist1[i] = list[i];
        }
        for (int i = 0; i < 10; i++) {
            sublist2[i] = list[i + 10];
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(sublist2[i]);
        }
    }
}
