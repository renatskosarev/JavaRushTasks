package com.javarush.task.jdk13.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(reader.readLine());
        }
        int minStringLength = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() < minStringLength) {
                minStringLength = list.get(i).length();
            }
        }
        ArrayList<String> results = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == minStringLength) {
                results.add(list.get(i));
            }
        }
        for (String result : results) {
            System.out.println(result);
        }
    }
}
