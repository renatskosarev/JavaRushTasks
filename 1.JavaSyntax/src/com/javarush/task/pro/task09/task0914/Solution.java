package com.javarush.task.pro.task09.task0914;

/* 
Обновление пути
*/

public class Solution {
    public static void main(String[] args) {
        String path = "/usr/java/jdk1.8/bin/";

        String jdk13 = "jdk-13";
        System.out.println(changePath(path, jdk13));
    }

    public static String changePath(String path, String jdk) {
        int firstIndex = path.indexOf("jdk");
        String first = path.substring(0, firstIndex);
        int lastIndex = path.indexOf("/", firstIndex);
        String last = path.substring(lastIndex, path.length());
        return first + jdk + last;
    }
}
