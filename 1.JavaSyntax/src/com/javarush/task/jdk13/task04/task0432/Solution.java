package com.javarush.task.jdk13.task04.task0432;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Хорошего не бывает много
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int num = Integer.parseInt(reader.readLine());
        int i = 0;
        while (i < num) {
            System.out.println(str);
            i++;
        }

    }
}
