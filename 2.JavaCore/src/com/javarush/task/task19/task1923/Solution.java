package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

        while (fileReader.ready()) {
            String[] words = fileReader.readLine().split(" ");
            for (String word : words) {
                if (containsDigit(word)) {
                    fileWriter.write(word + " ");
                }
            }
        }

        fileReader.close();
        fileWriter.close();
    }

    public static boolean containsDigit(String word) {
        char[] symbols = word.toCharArray();
        for (char symbol : symbols) {
            try {
                Integer.parseInt(symbol + "");
                return true;
            } catch (NumberFormatException e) {

            }
        }
        return false;
    }
}
