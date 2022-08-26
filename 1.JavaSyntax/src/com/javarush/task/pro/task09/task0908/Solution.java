package com.javarush.task.pro.task09.task0908;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    public static void main(String[] args) {
        String binaryNumber = null;
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = null;
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        String result = "";

        // проверки
        if (binaryNumber == null || binaryNumber.equals("")) {
            return "";
        }
        for (char symbol : binaryNumber.toCharArray()) {
            if (! (symbol == '1' || symbol == '0')) {
                return "";
            }
        }

        // перевод
        ArrayList<String> codes = new ArrayList(Arrays.asList("0000", "0001", "0010", "0011",
                "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101",
                "1110", "1111"));
        int strLength = binaryNumber.length();
        int strLengthMod4 = strLength % 4;
        if (strLengthMod4 != 0) {
            for (int i = 0; i < 4 - strLengthMod4; i++) {
                binaryNumber = "0" + binaryNumber;
            }
        }
        String tetrad;
        int subsubresult; //индекс тетрады в массиве
        String subresult;
        while (binaryNumber.length() > 0) {
            tetrad = binaryNumber.substring(0, 4);
            binaryNumber = binaryNumber.substring(4, binaryNumber.length());
            subsubresult = codes.indexOf(tetrad);
            subresult = subsubresult + "";
            if (subsubresult == 10) subresult = "a";
            if (subsubresult == 11) subresult = "b";
            if (subsubresult == 12) subresult = "c";
            if (subsubresult == 13) subresult = "d";
            if (subsubresult == 14) subresult = "e";
            if (subsubresult == 15) subresult = "f";
            result = result + subresult;
        }

        return result;
    }

    public static String toBinary(String hexNumber) {
        String result = "";

        // проверки
        if (hexNumber == null || hexNumber.equals("")) {
            return "";
        }
        ArrayList<Character> symbols = new ArrayList(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'));
        for (char symbol : hexNumber.toCharArray()) {
            if (! symbols.contains(symbol)) {
                return "";
            }
        }

        // перевод
        if (hexNumber.equals("0")) return "0";
        ArrayList<String> codes = new ArrayList(Arrays.asList("0000", "0001", "0010", "0011",
                "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101",
                "1110", "1111"));
        String subresult = "";
        for (char symbol : hexNumber.toCharArray()) {
            if (symbol == 'a') subresult = "1010";
            else if (symbol == 'b') subresult = "1011";
            else if (symbol == 'c') subresult = "1100";
            else if (symbol == 'd') subresult = "1101";
            else if (symbol == 'e') subresult = "1110";
            else if (symbol == 'f') subresult = "1111";
            else subresult = codes.get(Integer.parseInt(String.valueOf(symbol)));
            result = result + subresult;
        }


        return result;
    }
}
