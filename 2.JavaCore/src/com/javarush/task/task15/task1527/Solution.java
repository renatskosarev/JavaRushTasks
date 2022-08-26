package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String parameters = new StringBuilder(url).substring(url.indexOf('?') + 1);
        String[] params = parameters.split("&");
        boolean flag = false;
        String obj = "";

        ArrayList<String> result = new ArrayList<>();
        for (String parameter : params) {
            String currentParameter = parameter.split("=")[0];
            result.add(currentParameter);

            if (currentParameter.equals("obj")) {
                flag = true;
                obj = parameter.split("=")[1];
            }
        }

        for (int i = 0; i < result.size() - 1; i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println(result.get(result.size() - 1));

        if (flag) {
            try {
                alert(Double.parseDouble(obj));
            } catch (Exception e) {
                alert(obj);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
