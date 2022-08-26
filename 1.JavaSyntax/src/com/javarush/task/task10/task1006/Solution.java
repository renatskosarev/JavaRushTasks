package com.javarush.task.task10.task1006;

/* 
Задача №6 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        // result = 1000
        double d = (short) 2.50256e2d;  // 32.767
        char c = (short) 'd';  // d
        short s = (short) 2.22;  // 2
        int i = 150000;  // 18928
        float f =  0.50f;  // 0.0
        double result = f + (i / c) - (d * s) - 500e-3;
        System.out.println("result: " + result);
    }
}