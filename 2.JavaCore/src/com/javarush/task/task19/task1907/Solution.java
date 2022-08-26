package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(consoleReader.readLine());
        consoleReader.close();

        StringBuilder sb = new StringBuilder("");
        int counter = 0;

        while (fileReader.ready()) {
            char data = (char) fileReader.read();
            if (Character.isLetter(data)) {
                sb.append(data);
            } else {
                if (String.valueOf(sb).equals("world")) {
                    counter++;
                }
                sb = new StringBuilder("");
            }
        }
        if (String.valueOf(sb).equals("world")) counter++;

        System.out.println(counter);
        fileReader.close();
    }
}
