package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int symbolCount = 0;
        int spaceCount = 0;
        while (fis.available() > 0) {
            if (fis.read() == 32) {
                spaceCount++;
            }
            symbolCount++;
        }
        System.out.println(String.format("%.2f", spaceCount * 100.0 / symbolCount));
        fis.close();
    }
}
