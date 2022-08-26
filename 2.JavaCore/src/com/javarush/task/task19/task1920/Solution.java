package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        HashMap<String, Double> data = new HashMap<>();

        String randomName = "";
        while (reader.ready()) {
            String line = reader.readLine();
            String name = line.split(" ")[0];
            double value = Double.parseDouble(line.split(" ")[1]);
            if (data.containsKey(name)) {
                data.put(name, data.get(name) + value);
            } else {
                data.put(name, value);
            }
            randomName = name;
        }
        reader.close();

        ArrayList<String> maxNames = new ArrayList<>();
        maxNames.add(randomName);
        for (Map.Entry<String, Double> pair : data.entrySet()) {
            if (!maxNames.contains(pair.getKey()) && data.get(pair.getKey()) > data.get(maxNames.get(0))) {
                maxNames.clear();
                maxNames.add(pair.getKey());
            } else if (!maxNames.contains(pair.getKey())) {
                Double currentKey = data.get(pair.getKey());
                Double maxKey = data.get(maxNames.get(0));
                if (currentKey.compareTo(maxKey) == 0) {
                    maxNames.add(pair.getKey());
                }
            }
        }

        Collections.sort(maxNames);
        for (String name : maxNames) {
            System.out.println(name);
        }
    }
}
