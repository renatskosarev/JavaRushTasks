package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> files = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String file = reader.readLine();
            if (file.equals("end")) break;
            files.add(file);
        }

        String newFileName = "";
        if (files.get(0).contains("/")) {
            newFileName = files.get(0).substring(0, files.get(0).lastIndexOf('.'));
        } else {
            newFileName = files.get(0).substring(0, files.get(0).lastIndexOf("."));
        }
        //FileOutputStream fileWriter = new FileOutputStream(newFileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFileName));


        for (int i = 1; i <= files.size(); i++) {
            for (String file : files) {
                if (Integer.parseInt(file.substring(file.lastIndexOf("part") + 4, file.length())) == i) {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    while (bufferedReader.ready()) {
                        char data = (char) bufferedReader.read();
                        bufferedWriter.write(data);
                    }
                    bufferedReader.close();
                }
            }
        }

        bufferedWriter.close();
        reader.close();
    }
}