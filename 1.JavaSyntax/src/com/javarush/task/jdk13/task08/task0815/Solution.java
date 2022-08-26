package com.javarush.task.jdk13.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Одинаковые имя и фамилия
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

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int counter = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getValue().equals(name)) {
                counter++;
            }
        }
        return counter;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int counter = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getKey().equals(lastName)) {
                counter++;
            }
        }
        return counter;

    }

    public static void main(String[] args) {

    }
}
