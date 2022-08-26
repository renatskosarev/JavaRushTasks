package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        int[] bytes = new int[256];
        while (fis.available() > 0) {
            int data = fis.read();
            bytes[data] += 1;
        }
        ArrayList<Integer> result = new ArrayList<>();
        boolean first = true;

        for (int i = 0; i < 256; i++) {
            if (bytes[i] != 0) {
                if (first && bytes[i] != 0) {
                    first = false;
                    result.add(i);
                } else if (bytes[i] != 0 && bytes[i] < bytes[result.get(0)]) {
                    result.clear();
                    result.add(i);
                } else if (bytes[i] != 0 && bytes[i] == bytes[result.get(0)]) {
                    result.add(i);
                }
            }
        }

        for (int elem : result) {
            System.out.print(elem + " ");
        }
        fis.close();
        reader.close();
    }
}
