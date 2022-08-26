package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        raf.seek(Integer.parseInt(args[1]));
        byte[] b = new byte[args[2].length()];
        raf.read(b, 0, b.length);
        String text = new String(b, Charset.defaultCharset());
        raf.seek(raf.length());
        raf.write((text.equals(args[2]) + "").getBytes(StandardCharsets.UTF_8));
        raf.close();
    }
}
