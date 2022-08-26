package com.javarush.task.task18.task1822;

import java.io.*;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        reader.close();

        StringBuilder productName = new StringBuilder("");
        double price = 0;
        int quantity = 0;

        int id = Integer.parseInt(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] substrings = line.split(" ");
            if (Integer.parseInt(substrings[0]) == id) {
                for (int i = 1; i < substrings.length - 2; i++) {
                    productName.append(substrings[i] + " ");
                }
                productName = new StringBuilder(productName.substring(0, productName.length() - 1));
                price = Double.parseDouble(substrings[substrings.length - 2]);
                quantity = Integer.parseInt(substrings[substrings.length - 1]);
            }
        }

        System.out.println(id + " " + String.valueOf(productName) + " " + price + " " + quantity);

        bufferedReader.close();
    }
}
