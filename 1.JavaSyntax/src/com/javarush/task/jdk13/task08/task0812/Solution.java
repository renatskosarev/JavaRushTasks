package com.javarush.task.jdk13.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> nums = new ArrayList<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(reader.readLine()));
        }

        int maxSequence = 1;
        int currentSequence = 1;
        int lastNumber = nums.get(0);
        for (int i = 1; i < N; i++) {
            if (nums.get(i) == lastNumber) {
                currentSequence++;
                if (currentSequence > maxSequence) {
                    maxSequence = currentSequence;
                }
            } else {
                lastNumber = nums.get(i);
                currentSequence = 1;

            }
        }
        System.out.println(maxSequence);

    }
}
