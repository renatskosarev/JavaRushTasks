package com.javarush.task.jdk13.task04.task0425;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Координатные четверти
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        if(x > 0 && y > 0) System.out.println(1);
        if(x < 0 && y > 0) System.out.println(2);
        if (x < 0 && y < 0) System.out.println(3);
        if (x > 0 && y < 0) System.out.println(4);

    }
}
