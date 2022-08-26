package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);
        testString.printSomething();
        System.setOut(consoleStream);

        String[] symbols = outputStream.toString().split(" ");
        switch (symbols[1]) {
            case "+":
                int result = Integer.parseInt(symbols[0]) +
                        Integer.parseInt(symbols[2]);
                System.out.println(symbols[0] + " + " + symbols[2] + " = " + result);
                break;
            case "-":
                result = Integer.parseInt(symbols[0]) -
                        Integer.parseInt(symbols[2]);
                System.out.println(symbols[0] + " - " + symbols[2] + " = " + result);
                break;
            case "*":
                result = Integer.parseInt(symbols[0]) *
                        Integer.parseInt(symbols[2]);
                System.out.println(symbols[0] + " * " + symbols[2] + " = " + result);
                break;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

