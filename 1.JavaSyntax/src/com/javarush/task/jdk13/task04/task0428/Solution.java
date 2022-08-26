package com.javarush.task.jdk13.task04.task0428;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Положительные числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());
        int num3 = Integer.parseInt(reader.readLine());
        
        int counter = 0;
        
        if (num1 > 0) counter++;
        if (num2 > 0) counter++;
        if (num3 > 0) counter++;
        
        System.out.println(counter);

    }
}
