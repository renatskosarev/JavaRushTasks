package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int i = 51;;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        HashMap<Integer, Integer> map = new HashMap<>();
        FileInputStream fis = new FileInputStream(fileName);

        int data = fis.read();
        map.put(data, 1);
        while (fis.available() > 0) {
            data = fis.read();
            if (map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            } else {
                map.put(data, 1);
            }
        }

        boolean isFirst = true;
        ArrayList<Integer> maxKey = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair: map.entrySet()) {
            Integer key = pair.getKey();
            if (isFirst || pair.getValue() > map.get(maxKey.get(0))) {
                maxKey.clear();
                maxKey.add(pair.getKey());
                isFirst = false;
            } else if (pair.getValue() == map.get(maxKey.get(0))) {
                maxKey.add(pair.getKey());
            }
        }

        for (Integer intt : maxKey) {
            if (maxKey.indexOf(intt) == maxKey.size() - 1) {
                System.out.println(intt);
            } else {
                System.out.print(intt + " ");
            }
        }

        fis.close();
        reader.close();
    }
}
