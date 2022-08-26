package com.javarush.task.jdk13.task05.task0501;

/* 
Кошачья бойня(1)
*/

public class Solution {

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int thisCatScore = 0;
            int anotherCatScore = 0;
            if (this.age > anotherCat.age) thisCatScore++;
            else if (this.age != anotherCat.age) anotherCatScore++;
            if (this.weight > anotherCat.weight) thisCatScore++;
            else if (this.weight != anotherCat.weight) anotherCatScore++;
            if (this.strength > anotherCat.strength) thisCatScore++;
            else if (this.strength != anotherCat.strength) anotherCatScore++;
            return thisCatScore > anotherCatScore ? true : false;
        }
    }

    public static void main(String[] args) {
        Cat vaska = new Cat("Vaska", 4, 5, 2);
        Cat molly = new Cat("Molly", 3, 4, 1);
        Cat dany = new Cat("Dany", 5, 7, 3);
        System.out.println(vaska.fight(dany));
        System.out.println(vaska.fight(molly));
        System.out.println(dany.fight(molly));
    }
}
