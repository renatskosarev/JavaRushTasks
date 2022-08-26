package com.javarush.task.jdk13.task08.task0831;

import java.util.Arrays;

/* 
Любимые настолки
*/

public class Solution {

    public static BoardGame[] collection = new BoardGame[5];

    public static void main(String[] args) {
        BoardGame chess = new BoardGame();
        chess.name = "Шахматы";
        collection[0] = chess;

        BoardGame jenga = new BoardGame();
        jenga.name = "Дженга";
        collection[1] = jenga;

        BoardGame checkers = new BoardGame();
        checkers.name = "Шашки";
        collection[2] = checkers;

        BoardGame backgammon = new BoardGame();
        backgammon.name = "Нарды";
        collection[3] = backgammon;

        BoardGame uno = new BoardGame();
        uno.name = "Уно";
        collection[4] = uno;

        System.out.println(Arrays.toString(collection));
    }
}