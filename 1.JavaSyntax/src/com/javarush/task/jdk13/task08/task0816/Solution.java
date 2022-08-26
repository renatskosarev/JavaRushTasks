package com.javarush.task.jdk13.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Удалить всех людей, родившихся летом
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне0", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне1", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне2", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне3", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне4", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне5", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне6", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне7", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне8", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне9", dateFormat.parse("MAY 1 2012"));
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Map<String, Date> mapCopy = new HashMap<>(map);
        ArrayList<Integer> summerMonths = new ArrayList<>();
        summerMonths.add(5);
        summerMonths.add(6);
        summerMonths.add(7);
        for (Map.Entry<String, Date> pair : mapCopy.entrySet()) {
            if (summerMonths.contains(pair.getValue().getMonth())) {
                map.remove(pair.getKey());
            }
        }

    }

    public static void main(String[] args) throws ParseException {
        
    }
}
