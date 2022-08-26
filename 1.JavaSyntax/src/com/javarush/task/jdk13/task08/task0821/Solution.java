package com.javarush.task.jdk13.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Ильин", "Алексей");
        map.put("Иванов", "Дмитрий");
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

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
