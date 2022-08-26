package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = consoleReader.readLine();
            if (str.equals("exit")) {
                break;
            }
            new ReadThread(str);
        }
    }

    public static class ReadThread extends Thread {
        public String fileName;
        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.fileName = fileName;
            start();
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            int[] bytes = new int[256];
            try {
                FileInputStream fis = new FileInputStream(fileName);
                while (fis.available() > 0) {
                    int data = fis.read();
                    bytes[data - 1]++;
                }
                fis.close();

            } catch (IOException e) {
            }

            int maxIndex = 0;
            int max = 0;

            for (int i = 0; i < 256; i++) {
                if (bytes[i] != 0) {
                    maxIndex = i;
                    max = bytes[i];
                    break;
                }
            }

            for (int i = 0; i < 256; i++) {
                if (bytes[i] > max) {
                    maxIndex = i;
                    max = bytes[i];
                }
            }

            Solution.resultMap.put(fileName, maxIndex + 1);
        }
    }
}
