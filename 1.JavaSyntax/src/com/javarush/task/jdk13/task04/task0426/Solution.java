package com.javarush.task.jdk13.task04.task0426;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Строка - описание
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        if(number == 0) {
            System.out.println("ноль");
        } else {
        
        
        String plus = "отрицательное ";
        String even = "нечетное ";
        
        if (number > 0) plus = "положительное ";
        if (number % 2 == 0) even = "четное ";
        
        System.out.println(plus + even + "число");
        }
    }
}
