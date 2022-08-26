package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List horses) {
        this.horses = horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse maxDistanceHorse = horses.get(0);
        for (Horse horse : horses) {
            if (horse.getDistance() > maxDistanceHorse.getDistance()) {
                maxDistanceHorse = horse;
            }
        }
        return maxDistanceHorse;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String args[]) throws InterruptedException {
        List<Horse> horses = new ArrayList<Horse>() {{
                add(new Horse("Снег", 3, 0));
                add(new Horse("Быстрый", 3, 0));
                add(new Horse("Жанна", 3, 0));
            }};
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}
