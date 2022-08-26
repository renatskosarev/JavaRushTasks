package com.javarush.task.pro.task05.task0511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static int[][] multiArray;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        multiArray = new int[n][];
        for (int i = 0; i < n; i++) {
            n = Integer.parseInt(reader.readLine());
            multiArray[i] = new int[n];
        }

    }
}
