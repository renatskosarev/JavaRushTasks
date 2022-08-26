package com.javarush.task.jdk13.task03.task0319;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Зарплата через 5 лет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());
        System.out.println(name + " получает " + num1 + " через " + num2 + " лет.");

    }
}
