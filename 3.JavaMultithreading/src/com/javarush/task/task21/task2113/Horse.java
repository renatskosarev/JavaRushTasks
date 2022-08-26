package com.javarush.task.task21.task2113;

public class Horse {
    private String name;
    private double speed;
    private double distance;

    public void move() {
        distance += speed * Math.random();
    }

    public void print() {
        for (int i = 0; i < Math.floor(distance); i++) {
            System.out.print(".");
        }
        System.out.println(/*"\uD83C\uDFC7 " + */name);
    }

    // 🐎 🎠 🏇
    /*
               Раунд  |  Жанна  |  Быстрый  |  Снег
               ------------------------------------
                  1   |    1    |     3     |   2
                  2   |    2    |     1     |   3
                  3   |    3    |     1     |   2
                  4   |    1    |     2     |   3
                  5   |    1    |     2     |   3
TODO           ------------------------------------
                      |    8    |     9     |   13


     */

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
