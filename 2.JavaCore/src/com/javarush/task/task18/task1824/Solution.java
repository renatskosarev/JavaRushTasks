package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            File file = new File(reader.readLine());
            if (!file.exists()) {
                try {
                    FileInputStream fis = new FileInputStream(file);
                    fis.close();
                } catch (FileNotFoundException e) {
                    System.out.println(file.getPath());
                    break;
                }
            }
        }

        reader.close();
    }
}
