package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.io.File;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) {
        List<String> result = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        Collections.addAll(queue, new File(root).listFiles());

        while (!queue.isEmpty()) {
            File currentFile = queue.poll();
            if (currentFile.isDirectory()) {
                Collections.addAll(queue, currentFile.listFiles());
            } else {
                result.add(currentFile.getPath());
            }
        }

        return result;

    }

    public static void main(String[] args){
        // getFileTree("C:\\Users\\skosa\\Desktop\\task").stream().forEach(System.out::println);
    }
}
