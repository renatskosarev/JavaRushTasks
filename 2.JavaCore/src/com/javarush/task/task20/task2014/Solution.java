package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution sol = new Solution(4);
        System.out.println(sol);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("../object.ser"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("../object.ser"));

        oos.writeObject(sol);

        sol = null;

        sol = (Solution) ois.readObject();
        System.out.println(sol);
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
