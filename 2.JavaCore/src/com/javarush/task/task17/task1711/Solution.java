package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        String name = args[i];
                        String sex = args[i + 1];
                        Date bd = new SimpleDateFormat("dd/MM/yyyy").parse(args[i + 2]);
                        Person newPerson = sex.equals("м") ? Person.createMale(name, bd) : Person.createFemale(name, bd);
                        allPeople.add(newPerson);
                        System.out.println(allPeople.indexOf(newPerson));
                    }
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        int id = Integer.parseInt(args[i]);
                        String name = args[i + 1];
                        String sex = args[i + 2];
                        Date bd = new SimpleDateFormat("dd/MM/yyyy").parse(args[i + 3]);
                        allPeople.get(id).setName(name);
                        allPeople.get(id).setSex(sex.equals("м") ? Sex.MALE : Sex.FEMALE);
                        allPeople.get(id).setBirthDate(bd);
                    }
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                    }
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        int id = Integer.parseInt(args[i]);
                        String name = allPeople.get(id).getName();
                        String sex = allPeople.get(id).getSex() == Sex.MALE ? "м" : "ж";
                        String bd = dateFormat.format(allPeople.get(id).getBirthDate());
                        System.out.println(name + " " + sex + " " + bd);
                    }
                }
        }
    }
}
