package com.javarush.task.jdk13.task06.task0634;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Шахматная доска
*/

public class Solution {
    public static char[][] array;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        char nextChar = "#".charAt(0);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int chessboardSize = Integer.parseInt(reader.readLine());
        array = new char[chessboardSize][chessboardSize];
        for (int i = 0; i < chessboardSize; i++) {
            for (int j = 0; j < chessboardSize; j++) {
                array[i][j] = nextChar;
                if ((nextChar + "").equals("#")) {
                    nextChar = " ".charAt(0);
                } else {
                    nextChar = "#".charAt(0);
                }
            }
            if (chessboardSize % 2 == 0) {
                if ((nextChar + "").equals("#")) {
                    nextChar = " ".charAt(0);
                } else {
                    nextChar = "#".charAt(0);
                }
            }
        }


        for (int i = 0; i < chessboardSize; i++) {
            for (int j = 0; j < chessboardSize; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

    }
}
