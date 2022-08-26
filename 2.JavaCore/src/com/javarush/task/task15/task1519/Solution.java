package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            boolean hasResult = false;
            String str = reader.readLine();
            if (str.equals("exit")) break;


            if (str.contains(".")) {
                try {
                    print(Double.parseDouble(str));
                    hasResult = true;
                } catch (NumberFormatException e) {
                }
            }

            if (!hasResult) {
                try {
                    if (Integer.parseInt(str) > 0 && Integer.parseInt(str) < 128) {
                        print(Short.parseShort(str));
                        hasResult = true;
                    }
                } catch (NumberFormatException e) {
                }
            }

            if (!hasResult) {
                try {
                    if (Integer.parseInt(str) <= 0 || Integer.parseInt(str) >= 128) {
                        print(Integer.parseInt(str));
                        hasResult = true;
                    }
                } catch (NumberFormatException e) {
                }
            }

            if (!hasResult) {
                print(str);
            }

        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
