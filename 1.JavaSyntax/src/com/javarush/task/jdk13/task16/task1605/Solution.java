package com.javarush.task.jdk13.task16.task1605;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Solution {

    public void method1() throws IOException {
        throw new IOException();
    }
    public void method2() throws FileNotFoundException {
        throw new FileNotFoundException();
    }
    public void method3() throws ArrayIndexOutOfBoundsException {
    }
    public void method4() throws ArithmeticException{
    }
}
