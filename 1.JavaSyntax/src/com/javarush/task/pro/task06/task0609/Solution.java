package com.javarush.task.pro.task06.task0609;

/* 
Кубический калькулятор в кубе
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(ninthDegree(3));
    }

    public static long ninthDegree(long num) {
        return cube(cube(num));
    }

    public static long cube(long a){
        return a*a*a;
    }

    //напишите тут ваш код
}
