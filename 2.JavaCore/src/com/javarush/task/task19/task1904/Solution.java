package com.javarush.task.task19.task1904;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        File file = new File("d:/persons.txt");
        PersonScanner personScanner = new PersonScannerAdapter(new Scanner(file));
        System.out.println(personScanner.read());
        System.out.println(personScanner.read());
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] data = fileScanner.nextLine().split(" ");
            String fistName = data[1];
            String middleName = data[2];
            String lastName = data[0];
            Date birthday = new Date(Integer.parseInt(data[5]) - 1900,
                    Integer.parseInt(data[4]) - 1, Integer.parseInt(data[3]));
            return new Person(fistName, middleName, lastName, birthday);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
