package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Arrays;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c":
                String name = args[1];
                Date bd = new SimpleDateFormat("dd/MM/yyyy").parse(args[3]);
                Person newPerson = null;
                if (args[2].equals("м")) {
                    newPerson = Person.createMale(name, bd);
                } else {
                    newPerson = Person.createFemale(name, bd);
                }
                allPeople.add(newPerson);
                System.out.println(allPeople.indexOf(newPerson));
                break;
            case "-r":
                int id = Integer.parseInt(args[1]);
                name = allPeople.get(id).getName();
                DateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                String sex = allPeople.get(id).getSex().equals(Sex.MALE) ? "м" : "ж";
                String birthday = format.format(allPeople.get(id).getBirthDate());
                System.out.println(name + " " + sex + " " + birthday);
                break;
            case "-u":
                id = Integer.parseInt(args[1]);
                name = args[2];
                sex = args[3];
                bd = new SimpleDateFormat("dd/MM/yyyy").parse(args[4]);
                allPeople.get(id).setName(name);
                allPeople.get(id).setBirthDate(bd);
                if (sex.equals("м")) {
                    allPeople.get(id).setSex(Sex.MALE);
                } else {
                    allPeople.get(id).setSex(Sex.FEMALE);
                }
                break;
            case "-d":
                id = Integer.parseInt(args[1]);
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDate(null);
        }
    }
}
