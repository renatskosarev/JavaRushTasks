package com.javarush.task.jdk13.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        ArrayList<String> list = createList(N);
        swapElements(list, M);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    public static ArrayList<String> createList(int N) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Solution.reader.readLine());
        }
        return list;
    }

    public static void swapElements(ArrayList<String> list, int M) {
        for (int i = 0; i < M; i++) {
            list.add(list.get(0));
            list.remove(0);
        }
    }
}
