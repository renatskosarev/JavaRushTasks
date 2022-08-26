package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;

/* 
Загрузчик файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/assets/images/site/avatars/julio.png", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        String name = urlString.substring(urlString.lastIndexOf("/") + 1, urlString.length());
        URL url = new URL(urlString);
        InputStream input = url.openStream();

        Path tempFile = Files.createTempFile("", name);
        Files.copy(input, tempFile, StandardCopyOption.REPLACE_EXISTING);

        Path result = Paths.get(downloadDirectory.toString() + "/" + name);
        Files.move(tempFile, result);
        return result;
    }
}
