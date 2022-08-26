package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String result = "";

        while (reader.ready()) {
            String line = reader.readLine();
            String[] words = line.split(" ");
            for (String word : words) {
                if (isLong(word)) {
                    result += word + ",";
                }
            }
        }

        result = result.substring(0, result.length() - 1);
        writer.write(result);

        writer.close();
        reader.close();
    }

    public static boolean isLong(String word) {
        return word.length() > 6;
    }
}
