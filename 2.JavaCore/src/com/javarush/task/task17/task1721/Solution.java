package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(consoleReader.readLine());
        File file2 = new File(consoleReader.readLine());
        BufferedReader br1 = new BufferedReader(new FileReader(file1));
        BufferedReader br2 = new BufferedReader(new FileReader(file2));

        while (br1.ready()) {
            allLines.add(br1.readLine());
        }
        while (br2.ready()){
            forRemoveLines.add(br2.readLine());
        }

        Solution sol = new Solution();
        sol.joinData();

        consoleReader.close();
        br1.close();
        br2.close();
    }

    public void joinData() throws CorruptedDataException {
        for (String line: forRemoveLines) {
            if (! allLines.contains(line)) {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
        allLines.removeAll(forRemoveLines);
    }
}
