package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, Double> data = new HashMap<>();
        ArrayList<String> forSort = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String name = line.split(" ")[0];
            double salary = Double.parseDouble(line.split(" ")[1]);
            if (data.containsKey(name)) {
                data.put(name, data.get(name) + salary);
            } else {
                data.put(name, salary);
            }

            if (!forSort.contains(name)) {
                forSort.add(name);
            }
        }
        bufferedReader.close();
        Collections.sort(forSort);

        for (String name : forSort) {
            for (Map.Entry<String, Double> pair : data.entrySet()) {
                if (pair.getKey().equals(name)) {
                    System.out.println(name + " " + pair.getValue());
                }
            }
        }
    }
}
