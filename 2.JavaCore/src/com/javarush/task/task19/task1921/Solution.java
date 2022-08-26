package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()) {
            String line = reader.readLine();
            String[] arr = line.split(" ");
            StringBuilder sbName = new StringBuilder("");
            for (int i = 0; i < arr.length - 3; i++) {
                sbName.append(arr[i] + " ");
            }
            String name = String.valueOf(sbName).substring(0, sbName.length() - 1);

            int day = Integer.parseInt(arr[arr.length - 3]);
            int month = Integer.parseInt(arr[arr.length - 2]);
            int year = Integer.parseInt(arr[arr.length - 1]);
            Date date = new Date(year - 1900, month - 1, day);
            PEOPLE.add(new Person(name, date));
        }

        reader.close();
        System.out.println(PEOPLE);
    }
}
