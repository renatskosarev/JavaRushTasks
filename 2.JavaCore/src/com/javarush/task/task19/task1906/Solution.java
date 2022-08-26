package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(consoleReader.readLine());
        FileWriter fileWriter = new FileWriter(consoleReader.readLine())) {

            while (fileReader.ready()) {
                fileReader.read();
                fileWriter.write(fileReader.read());
            }
        }
    }
}
