package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());
        File file2 = new File(reader.readLine());
        reader.close();

        StringBuilder fileContent = new StringBuilder("");
        FileInputStream fis = new FileInputStream(file1);
        while (fis.available() > 0) {
            fileContent.append((char) fis.read());
        }
        String[] nums = String.valueOf(fileContent).split(" ");

        FileWriter fw = new FileWriter(file2);
        for (String num : nums) {
            double number = Double.parseDouble(num);
            fw.write(Math.round(number) + " ");
        }

        fis.close();
        fw.close();
    }
}
