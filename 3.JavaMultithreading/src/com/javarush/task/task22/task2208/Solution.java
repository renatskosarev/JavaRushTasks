package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        /*Map<String, String> data = new HashMap<String, String>();
        data.put("name", "Ivanov");
        data.put("country", "Ukraine");
        data.put("city", "Kiev");
        data.put("age", "26");
        System.out.println(getQuery(data));*/
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder("");

        boolean hasFirstValueFlag = false;
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null) {
                if (!hasFirstValueFlag) {
                    sb.append(String.format("%s = '%s'", pair.getKey(), pair.getValue()));
                    hasFirstValueFlag = true;
                } else {
                    sb.append(String.format(" and %s = '%s'", pair.getKey(), pair.getValue()));
                }
            }
        }
        return sb.toString();
    }
}
