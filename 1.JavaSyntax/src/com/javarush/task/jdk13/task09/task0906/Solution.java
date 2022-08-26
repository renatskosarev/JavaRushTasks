package com.javarush.task.jdk13.task09.task0906;

/* 
Логирование стек трейса
*/

public class Solution {

    public static void main(String[] args) {
        log("In method");
    }

    public static void log(String text) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String className = stackTraceElements[2].getClassName() + "";
        String methodName = stackTraceElements[2].getMethodName() + "";
        System.out.println(className + ": " + methodName + ": " + text);

    }
}
