package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        switch (args[0]) {
            case "-e":
                FileInputStream fis = new FileInputStream(args[1]);
                FileOutputStream fos = new FileOutputStream(args[2]);
                while (fis.available() > 0) {
                    fos.write(fis.read() + 1);
                }
                fis.close();
                fos.close();
                break;
            case "-d":
                FileInputStream fis1 = new FileInputStream(args[1]);
                FileOutputStream fos1 = new FileOutputStream(args[2]);
                while (fis1.available() > 0) {
                    fos1.write(fis1.read() - 1);
                }
                fis1.close();
                fos1.close();

        }
    }

}
