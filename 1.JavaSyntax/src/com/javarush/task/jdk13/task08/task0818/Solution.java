package com.javarush.task.jdk13.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Налоговая и зарплаты
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Иванов0", 500);
        map.put("Иванов1", 500);
        map.put("Иванов2", 500);
        map.put("Иванов3", 500);
        map.put("Иванов4", 500);
        map.put("Иванов5", 500);
        map.put("Иванов6", 500);
        map.put("Иванов7", 500);
        map.put("Иванов8", 500);
        map.put("Иванов9", 500);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Map<String, Integer> copyMap = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair : copyMap.entrySet()) {
            if (pair.getValue() < 500) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}