package com.javarush.task.jdk13.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Два массива
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strList = new String[10];
        int[] intList = new int[10];
        for (int i = 0; i < 10; i++) {
            strList[i] = reader.readLine();
        }
        for (int i = 0; i < 10; i++) {
            intList[i] = strList[i].length();
            System.out.println(intList[i]);
        }

    }
}
