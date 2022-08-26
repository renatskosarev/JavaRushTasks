package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        HashMap<Character, Integer> symbols = new HashMap<>();
        while (fis.available() > 0) {
            char data = (char) fis.read();
            if (symbols.containsKey(data)) {
                symbols.put(data, symbols.get(data) + 1);
            } else {
                symbols.put(data, 1);
            }
        }

        ArrayList<Character> sortedKeys = new ArrayList<>(symbols.keySet());
        Collections.sort(sortedKeys);

        HashMap<Character, Integer> result = new LinkedHashMap<>();
        for (Character ch : sortedKeys) {
            result.put(ch, symbols.get(ch));
        }
        //error

        for(Map.Entry<Character, Integer> pair : result.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        fis.close();
    }
}
