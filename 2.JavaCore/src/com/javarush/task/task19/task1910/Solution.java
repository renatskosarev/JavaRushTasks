package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(consoleReader.readLine()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(consoleReader.readLine()))) {

            while (bufferedReader.ready()) {
                char data = (char) bufferedReader.read();
                if (data == ' ' || Character.isLetter(data) || Character.isDigit(data)) {
                    bufferedWriter.write(data);
                }
            }
        }

    }
}
