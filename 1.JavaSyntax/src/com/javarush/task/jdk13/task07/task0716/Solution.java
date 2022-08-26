package com.javarush.task.jdk13.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лира");
        strings.add("лоза");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {

        ArrayList<String> copy = new ArrayList<>(strings);
        for (int i = 0; i < copy.size(); i++) {
            if (copy.get(i).contains("р") && copy.get(i).contains("л")) {

            } else if (copy.get(i).contains("р")) {
                strings.remove(copy.get(i));
            } else if (copy.get(i).contains("л")) {
                strings.add(i, copy.get(i));
            }
        }

        return strings;
    }
}