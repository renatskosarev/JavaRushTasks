package com.javarush.task.jdk13.task04.task0423;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
И 18-ти достаточно
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        if (age > 20) System.out.println("И 18-ти достаточно");

    }
}
