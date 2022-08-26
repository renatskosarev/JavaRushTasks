package com.javarush.task.jdk13.task07.task0707;

import java.util.ArrayList;

/* 
5 различных строк в списке
*/

public class Solution {
    
    public static ArrayList<String> list;
    
    public static void main(String[] args) {
        list = new ArrayList<>();
        initializeArrayList();
        System.out.println(list.size());
        for (String str : list) {
            System.out.println(str);
        }
    }

    public static void initializeArrayList() {
        list.add("ivan");
        list.add("alexey");
        list.add("anna");
        list.add("nikita");
        list.add("petr");
    }
}
