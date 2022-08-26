package com.javarush.task.jdk13.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улица и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        int[] list = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < list.length; i++) {
            list[i] = Integer.parseInt(reader.readLine());
        }
        int even = 0; //четный
        int odd = 0; //нечетный
        for (int i = 0; i < list.length; i++) {
            if (i % 2 == 0) {
                even += list[i];
            } else {
                odd += list[i];
            }
        }
        if (even > odd) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }
        if (odd > even) {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}
