package com.javarush.task.jdk13.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man man1 = new Man("Igor", 32, "unknown");
        Man man2 = new Man("Ivan", 28, "unknown");
        Woman woman1 = new Woman("Anastasia", 23, "unknown");
        Woman woman2 = new Woman("Anna", 23, "unknown");
        man1.tooString();
        man2.tooString();
        woman1.tooString();
        woman2.tooString();
    }

    public static class Man {
        String name;
        int age;
        String address;
        
        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
        
        public void tooString() {
            System.out.println(name + " " + age + " " + address);
        }
    }
    
    public static class Woman {
        String name;
        int age;
        String address;
        
        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
        
        public void tooString() {
            System.out.println(name + " " + age + " " + address);
        }
    }
    
    
}
