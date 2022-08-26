package com.javarush.task.task18.task1807;

import java.io.*;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(consoleReader.readLine());

        int counter = 0;
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (data == 44) {
                counter++;
            }
        }
        System.out.println(counter);

        consoleReader.close();
        inputStream.close();
    }
}
