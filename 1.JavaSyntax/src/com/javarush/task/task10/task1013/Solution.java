package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private int age;
        private String address;
        private char sex;
        private String mother;
        private String father;

        public Human(String name) {
            this.name = name;
        }

        public Human(int age) {
            this.age = age;
        }

        public Human(char sex) {
            this.sex = sex;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public Human(String name, int age, String address, char sex, String mother, String father) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.sex = sex;
            this.mother = mother;
            this.father = father;
        }

        public Human(String name, int age, String mother, String father) {
            this.name = name;
            this.age = age;
            this.mother = mother;
            this.father = father;
        }

        public Human(String name, char sex) {
            this.name = name;
            this.sex = sex;
        }

        public Human(char sex, String mother, String father) {
            this.sex = sex;
            this.mother = mother;
            this.father = father;
        }

        public Human(String name, String address, char sex, String mother, String father) {
            this.name = name;
            this.address = address;
            this.sex = sex;
            this.mother = mother;
            this.father = father;
        }
    }
}
