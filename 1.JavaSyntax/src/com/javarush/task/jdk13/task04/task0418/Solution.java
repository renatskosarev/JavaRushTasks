package com.javarush.task.jdk13.task04.task0418;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Минимум двух чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());
        if(num1 > num2) {
            System.out.println(num2);
        } else {
            System.out.println(num1);
        }
    }
}