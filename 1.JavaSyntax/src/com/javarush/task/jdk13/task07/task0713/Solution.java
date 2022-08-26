package com.javarush.task.jdk13.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Три массива
*/

public class Solution {

    public static ArrayList<Integer> numbers = new ArrayList<>();
    public static ArrayList<Integer> divBy3 = new ArrayList<>();
    public static ArrayList<Integer> divBy2 = new ArrayList<>();
    public static ArrayList<Integer> others = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            numbers.add(Integer.parseInt(reader.readLine()));
        }

        for (Integer element : numbers) {
            if (element % 3 == 0) {
                divBy3.add(element);
            }
            if (element % 2 == 0) {
                divBy2.add(element);
            }
            if (element % 3 != 0 && element % 2 != 0) {
                others.add(element);
            }
        }

        printList(divBy3);
        printList(divBy2);
        printList(others);
    }

    public static void printList(ArrayList<Integer> list) {
        for (Integer element : list) {
            System.out.println(element);
        }
    }
}
