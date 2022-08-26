package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(consoleReader.readLine());
        File file2 = new File(consoleReader.readLine());

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));

        while (bufferedReader.ready()) {
            char data = (char) bufferedReader.read();
            bufferedWriter.write(data == '.' ? '!' : data);
        }

        consoleReader.close();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
