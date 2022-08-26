package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("лучший сервис обучения Java."));
//        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        String result = "";
        String[] arr = string.split(" ");
        if (arr.length < 5) throw new TooShortStringException();
        result = arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4];

        return result;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
