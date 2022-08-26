package com.javarush.task.jdk13.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    String name;
    int age;
    int weight;
    String color;
    String address;

    public Cat(String name) {
        this.name = name;
        this.age = 4;
        this.weight = 7;
        this.color = "White";
        this.address = null;
    }
    public Cat(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = "White";
        this.address = null;
    }
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 4;
        this.color = "White";
        this.address = null;
    }
    public Cat(int weight, String color) {
        this.weight = weight;
        this.color = color;
        this.name = null;
        this.address = null;
        this.age = 7;
    }
    public Cat(int weight, String color, String address) {
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.name = null;
        this.age = 4;
    }


    public static void main(String[] args) {

    }
}
