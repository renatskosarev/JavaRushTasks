package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);

        File results = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, results);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(results))) {
            visitDirectory(path, writer);
        }
    }

    public static void visitDirectory(File dir, Writer writer) throws IOException {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                visitDirectory(file, writer);
            } else {
                if (file.length() <= 50) {
                    FileReader reader = new FileReader(file);
                    String forWrite = "";
                    while (reader.ready()) {
                        forWrite += (char) reader.read();
                    }
                    reader.close();

                    writer.write(forWrite + "\n");
                }
            }
        }
    }
}