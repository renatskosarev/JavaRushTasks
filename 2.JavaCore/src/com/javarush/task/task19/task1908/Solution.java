package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(consoleReader.readLine());
        File file2 = new File(consoleReader.readLine());

        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2));

        String[] file1Content = fileReader.readLine().split(" ");
        for (String str : file1Content) {
            if (isNumber(str)) {
                fileWriter.write(str + " ");
            }
        }

        fileReader.close();
        consoleReader.close();
        fileWriter.close();
    }

    public static boolean isNumber(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
