package com.javarush.task.task17.task1712;

public class Table {
    private static byte tableNumber;
    private byte number = ++tableNumber;  // что-то странное

    public Order getOrder() {
//        System.out.println("debug: " + tableNumber + " " + number);
        return new Order(number);
    }
}
