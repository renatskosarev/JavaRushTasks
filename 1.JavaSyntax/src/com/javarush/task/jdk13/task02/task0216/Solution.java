package com.javarush.task.jdk13.task02.task0216;

/*
Минимум трех чисел
*/

public class Solution {
    public static int min(int a, int b, int c) {
        int min = 0;
        min = a < b ? a : b;
        min = min < c ? min : c;
        return min;

    }

    public static void main(String[] args) {
        System.out.println(min(1, 2, 3));
        System.out.println(min(-1, -2, -3));
        System.out.println(min(3, 5, 3));
        System.out.println(min(5, 5, 10));
    }
}