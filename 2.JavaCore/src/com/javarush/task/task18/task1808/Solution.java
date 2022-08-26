package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(consoleReader.readLine());
        FileOutputStream outputStream1 = new FileOutputStream(consoleReader.readLine());
        FileOutputStream outputStream2 = new FileOutputStream(consoleReader.readLine());

        int symbolsCount = inputStream.available();
        int forVar = symbolsCount % 2 == 0 ? (int) (Math.ceil(symbolsCount / 2)) : (int) (Math.ceil(symbolsCount / 2 + 1));

        for (int i = 0; i < forVar; i++) {
            outputStream1.write(inputStream.read());
        }
        while (inputStream.available() > 0) {
            outputStream2.write(inputStream.read());
        }

        consoleReader.close();
        inputStream.close();
        outputStream1.close();
        outputStream2.close();
    }
}
