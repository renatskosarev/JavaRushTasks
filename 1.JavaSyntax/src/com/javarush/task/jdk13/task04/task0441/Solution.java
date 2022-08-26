package com.javarush.task.jdk13.task04.task0441;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее такое среднее
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        System.out.println(middle(a, b, c));

    }
    public static int middle(int a, int b, int c) {
        if (a == b && b == c) return a;
        if (a == b) return a;
        if (b == c) return b;
        if (a == c) return c;
        if ((a > b && a < c) || (a < b && a > c)) return a;
        if ((b > a && b < c) || (b < a && b > c)) return b;
        return c;
    }
}
