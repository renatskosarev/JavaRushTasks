package com.javarush.task.jdk13.task12.task1203;

/* 
Сознательный выбор
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(isByte(12)); // true
        System.out.println(isShort(130999)); // false
        System.out.println(isInt(1999939990L)); // true
        System.out.println(isInt(19999999939990L)); // false
    }

    public static boolean isByte(long l) {
        byte l1 = (byte) l;
        if (l == l1) return true;
        return false;
    }

    public static boolean isShort(long l) {
        short l1 = (short) l;
        if (l == l1) return true;
        return false;
    }

    public static boolean isInt(long l) {
        int l1 = (int) l;
        if (l == l1) return true;
        return false;
    }
}
