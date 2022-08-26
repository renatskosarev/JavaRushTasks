package com.javarush.task.jdk13.task04.task0442;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Суммирование
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int num;
        int sum = -1;
        while (true) {
            num = Integer.parseInt(reader.readLine());
            if (num == -1) break;
            sum += num;
        }
        System.out.println(sum);


    }
}
