package com.javarush.task.task13.task1315;

/* 
Том, Джерри и Спайк
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface Movable {
        void move();
    }

    public interface Edible {
        void beEaten();
    }

    public interface Eat {
        void eat();
    }

    public class Dog implements Eat, Movable{

        @Override
        public void move() {
            
        }

        @Override
        public void eat() {

        }
    }

    public class Cat implements Eat, Edible, Movable {
        @Override
        public void move() {

        }

        @Override
        public void beEaten() {

        }

        @Override
        public void eat() {

        }
    }

    public class Mouse implements Edible, Movable {
        @Override
        public void move() {

        }

        @Override
        public void beEaten() {

        }
    }
}