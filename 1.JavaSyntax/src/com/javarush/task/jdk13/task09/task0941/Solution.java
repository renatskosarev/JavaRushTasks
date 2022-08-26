package com.javarush.task.jdk13.task09.task0941;

import java.util.Arrays;
import java.util.StringTokenizer;

/* 
IPv6
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(map("2001:db8:11a3:9d7:1f34:8a2e:7a0:765d")));
    }

    public static String[] map(String ipv6) {
        StringTokenizer tokenizer = new StringTokenizer(ipv6, ":");
        int count = tokenizer.countTokens();
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = tokenizer.nextToken();
        }
        return result;
    }
}
