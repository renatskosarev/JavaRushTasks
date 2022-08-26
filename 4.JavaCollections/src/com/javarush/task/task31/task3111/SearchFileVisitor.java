package com.javarush.task.task31.task3111;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String strContent = new String(content);

        boolean fits = true;

        if (partOfName != null && !file.getFileName().toString().contains(partOfName))
            fits = false;
        if (fits && partOfContent != null && !strContent.contains(partOfContent))
            fits = false;
        if (fits && minSize != 0 && content.length < minSize)
            fits = false;
        if (fits && maxSize != 0 && content.length > maxSize)
            fits = false;

        if (fits)
            foundFiles.add(file);
        return super.visitFile(file, attrs);
    }


}
