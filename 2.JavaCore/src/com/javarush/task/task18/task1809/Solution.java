package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.*;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine())) {
            ArrayList<Integer> list = new ArrayList<>();
            while (inputStream.available() > 0) {
                list.add(inputStream.read());
            }
            Collections.reverse(list);
            for (Integer element : list) {
                outputStream.write(element);
            }
        }
    }
}
