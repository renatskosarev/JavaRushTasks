package com.javarush.task.task18.task1819;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());
        File file2 = new File(reader.readLine());
        StringBuilder buffer = new StringBuilder("");

        FileInputStream fis = new FileInputStream(file1);
        while (fis.available() > 0) {
            buffer.append((char)fis.read());
        }
        FileOutputStream fos = new FileOutputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);

        while (fis2.available() > 0) {
            fos.write(fis2.read());
        }
        for (byte ch : (String.valueOf(buffer)).getBytes(StandardCharsets.UTF_8)) {
            char chh = (char) ch;
            fos.write(chh);
        }

        fis.close();
        fis2.close();
        fos.close();
    }
}
