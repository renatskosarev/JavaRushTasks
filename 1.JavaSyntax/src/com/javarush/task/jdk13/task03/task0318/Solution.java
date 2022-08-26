package com.javarush.task.jdk13.task03.task0318;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Как захватить мир
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        System.out.println("Через " + age + " лет " + name + " захватит мир. Му-ха-ха!");

    }
}
