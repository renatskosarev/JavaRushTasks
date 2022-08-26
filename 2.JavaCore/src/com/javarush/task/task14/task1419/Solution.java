package com.javarush.task.task14.task1419;

import javax.naming.directory.InvalidAttributesException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.invoke.LambdaConversionException;
import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        exceptions.add(new NullPointerException());
        exceptions.add(new InterruptedException());
        exceptions.add(new StringIndexOutOfBoundsException());
        exceptions.add(new IndexOutOfBoundsException());
        exceptions.add(new RuntimeException());
        exceptions.add(new Exception());
        exceptions.add(new LambdaConversionException());
        exceptions.add(new DataFormatException());
        exceptions.add(new InvalidAttributesException());

    }
}
