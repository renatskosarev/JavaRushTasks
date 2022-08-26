package com.javarush.task.task29.task2913;

import java.util.ArrayList;
import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        ArrayList<String> list = new ArrayList<>();
        if (a < b) {
            for (int i = a; i < b + 1; i++) {
                list.add(i + "");
            }
        } else {
            for (int i = a; i >= b; i--) {
                list.add(i + "");
            }
        }
        return String.join(" ", list);
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}