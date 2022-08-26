package com.javarush.task.jdk13.task05.task0528;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Solution {
    public static void main(String[] args) {
        Date currentDate = new Date();
        int day1 = currentDate.getDate();
        String day = day1 + "";
        int month1 = currentDate.getMonth() + 1;
        String month = month1 + "";
        int year = currentDate.getYear() + 1900;
        if (day1 < 10) {
            day = "0" + day;
        }
        if (month1 < 10) {
            month = "0" + month;
        }
        System.out.println(day + " " + month + " " + year);

    }
}
