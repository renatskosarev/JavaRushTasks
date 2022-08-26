package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileOutputStream file1fos = new FileOutputStream(file1);
        FileInputStream file2fis = new FileInputStream(file2);
        FileInputStream file3fis = new FileInputStream(file3);

        while (file2fis.available() > 0) {
            file1fos.write(file2fis.read());
        }
        while (file3fis.available() > 0) {
            file1fos.write(file3fis.read());
        }
        file1fos.close();
        file2fis.close();
        file3fis.close();
    }
}
