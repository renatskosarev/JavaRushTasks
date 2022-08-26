package com.javarush.task.jdk13.task04.task0413;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
День недели
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        System.out.println(Solution.getDayOfWeek(number));

    }
    
    public static String getDayOfWeek(int number) {
        if (number < 1 || number > 7) {
            return "такого дня недели не существует";
        }
        if(number == 1) return "понедельник";
        if(number == 2) return "вторник";
        if(number == 3) return "среда";
        if(number == 4) return "четверг";
        if(number == 5) return "пятница";
        if(number == 6) return "суббота";
        return "воскресенье";
    }
}