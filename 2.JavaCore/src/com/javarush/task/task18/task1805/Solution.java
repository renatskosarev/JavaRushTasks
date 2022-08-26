package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        ArrayList<Integer> bytes = new ArrayList<>();
        while (fis.available() > 0) {
            int data = fis.read();
            if (!bytes.contains(data)) {
                bytes.add(data);
            }
        }
        Collections.sort(bytes);
        for (int elem : bytes) {
            System.out.print(elem + " ");
        }
        fis.close();
        reader.close();
    }
}
