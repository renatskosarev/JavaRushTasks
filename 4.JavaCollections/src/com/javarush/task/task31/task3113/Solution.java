package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
��� ������ �����?
*/

public class Solution {
    static int foldersNumber = -1;
    static int filesNumber = 0;
    static long filesSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path dirPath = Paths.get(reader.readLine());

        if (!Files.isDirectory(dirPath)) {
            System.out.println(dirPath + " - �� �����");
            return;
        }

        Files.walkFileTree(dirPath, new MyFileVisitor());

        System.out.println("����� ����� - " + foldersNumber);
        System.out.println("����� ������ - " + filesNumber);
        System.out.println("����� ������ - " + filesSize);
    }
}
