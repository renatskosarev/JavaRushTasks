package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    private final static Character[] ENGLISH_CHARACTERS_ARRAY = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'
            , 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm'
            , 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int englishAlphasCount = 0;
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < ENGLISH_CHARACTERS_ARRAY.length; i++) {
            list.add(ENGLISH_CHARACTERS_ARRAY[i]);
        }
        while (fis.available() > 0) {
            char data = (char) fis.read();
            if (list.contains(data)) englishAlphasCount++;
        }
        System.out.println(englishAlphasCount);
        fis.close();
    }
}
