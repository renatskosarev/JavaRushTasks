package com.javarush.task.jdk13.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Минимальное или максимальное
*/

public class Solution {

    public static ArrayList<String> strings;

    public static void main(String[] args) throws IOException {
        strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
        }

        int minLengthString = strings.get(0).length();
        int maxStringLength = strings.get(0).length();
        for (int i = 1; i < strings.size(); i++) {
            if (strings.get(i).length() < minLengthString) {
                minLengthString = strings.get(i).length();
            }
            if (strings.get(i).length() > maxStringLength) {
                maxStringLength = strings.get(i).length();
            }
        }

        for (String elem : strings) {
            if (elem.length() == minLengthString || elem.length() == maxStringLength){
                System.out.println(elem);
                break;
            }
        }
    }
}
