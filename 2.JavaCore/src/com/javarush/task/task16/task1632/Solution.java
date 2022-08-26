package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) throws IOException {
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
            }
            System.out.println("InterruptedException");
        }
    }

    public static class Thread3 extends Thread {
        @Override
        public void run() {
            while(true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message {
        @Override
        public void run() {
            while (!isInterrupted()) {
            }
        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }

    public static class Thread5 extends Thread {
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            while (true) {
                String str = null;
                try {
                    str = reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (str.equals("N")) {
                    break;
                }
                sum += Integer.parseInt(str);
            }
            System.out.println(sum);
        }
    }
}