package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);
        testString.printSomething();
        System.setOut(consoleStream);

        System.out.println(outputStream.toString());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileWriter = new FileOutputStream(reader.readLine());
        fileWriter.write(outputStream.toByteArray());

        outputStream.close();
        printStream.close();
        fileWriter.close();
        reader.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}