package com.javarush.task.jdk13.task04.task0427;

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
        
        String innnt = "однозначное ";
        String even = "нечетное ";
        if(number % 2 == 0) even = "четное ";
        
        String str = number + "";
        if(str.length() == 2) innnt = "двузначное ";
        if (str.length() == 3) innnt = "трехзначное ";
        
        if(number < 1 || number > 999) {
            
        } else {
            System.out.println(even + innnt + "число");
        }

    }
}
