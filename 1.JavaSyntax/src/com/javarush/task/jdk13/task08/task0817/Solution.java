package com.javarush.task.jdk13.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Удалить людей, имеющих одинаковые имена
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Алексеев", "Алексей");
        map.put("Иванов", "Иван");
        map.put("Дмитриев", "Дмитрий");
        map.put("Никитин", "Никита");
        map.put("Александров", "Александр");
        map.put("Егоров", "Егор");
        map.put("Ильин", "Илья");
        map.put("Назаров", "Назар");
        map.put("Степанов", "Степан");
        map.put("Артемов", "Артем");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        ArrayList<String> removeList = new ArrayList<>();
        for (Map.Entry<String, String> pair : map.entrySet()) {
            for (Map.Entry<String, String> pair2 : map.entrySet()) {
                if (pair.getKey().equals(pair2.getKey())) {
                    continue;
                }
                if (pair.getValue().equals(pair2.getValue())) {
                    removeList.add(pair.getValue());
                    removeList.add(pair2.getValue());
                }
            }
        }
        for (String removeElement : removeList) {
            removeItemFromMapByValue(map, removeElement);
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}
