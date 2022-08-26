package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "w");
        if (raf.length() < Integer.parseInt(args[1])) {
            raf.seek(raf.length());
        } else {
            raf.seek(Integer.parseInt(args[1]));
        }
        raf.write(args[2].getBytes(StandardCharsets.UTF_8));
    }
}
