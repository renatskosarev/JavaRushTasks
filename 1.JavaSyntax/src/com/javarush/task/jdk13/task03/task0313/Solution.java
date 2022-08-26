package com.javarush.task.jdk13.task03.task0313;

/* 
Мама мыла раму
*/

public class Solution {
    public static void main(String[] args) {
        String a = "Мама"; String b = "Мыла"; String c = "Раму"; String format = "%s%s%s";
        System.out.println(String.format(format, a, b, c));
        System.out.println(String.format(format, a, c, b));
        System.out.println(String.format(format, b, a, c));
        System.out.println(String.format(format, b, c, a));
        System.out.println(String.format(format, c, a, b));
        System.out.println(String.format(format, c, b, a));
    }
}
