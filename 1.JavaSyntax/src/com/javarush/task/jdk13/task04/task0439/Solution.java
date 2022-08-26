package com.javarush.task.jdk13.task04.task0439;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Все любят Мамбу
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        for (int i = 1; i <= 10; i++) {
            System.out.println(name + " любит меня.");
        }

    }
}
