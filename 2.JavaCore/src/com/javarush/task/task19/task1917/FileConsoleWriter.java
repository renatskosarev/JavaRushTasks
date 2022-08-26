package com.javarush.task.task19.task1917;

import java.io.*;

/* 
Свой FileWriter
*/

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }


    public void write(char[] cbuf, int off, int len) throws IOException {
        StringBuilder result = new StringBuilder("");
        for (char symbol : cbuf) {
            result.append(symbol);
        }
        System.out.println(String.valueOf(result).substring(off, off + len));

        fileWriter.write(cbuf, off, len);
    }

    public void write(int c) throws IOException {
        System.out.println((char) c);
        fileWriter.write(c);
    }

    public void write(String str) throws IOException {
        System.out.println(str);
        fileWriter.write(str);
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.println(str.substring(off, off + len));
    }

    public void write(char[] cbuf) throws IOException {
        StringBuilder result = new StringBuilder("");
        for (char symbol : cbuf) {
            result.append(symbol);
        }
        System.out.println(result);

        fileWriter.write(cbuf);
    }

    public void close() throws IOException {
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        FileConsoleWriter fcw = new FileConsoleWriter("d:/file.txt");
        fcw.write("Hello, world");
        fcw.write(32);
        fcw.close();
    }
}
