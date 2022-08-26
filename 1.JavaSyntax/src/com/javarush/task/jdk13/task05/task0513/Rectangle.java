package com.javarush.task.jdk13.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    int top;
    int left;
    int width;
    int height;

    public void initialize(int top) {
        this.top = top;
    }

    public void initialize(int top, int left) {
        this.top = top;
        this.left = left;
    }

    public void initialize(int top, int left, int width) {
        this.top = top;
        this.left = left;
        this.width = width;
    }

    public void initialize(Rectangle rectangle) {
        this.height = rectangle.height;
        this.top = rectangle.top;
        this.left = rectangle.left;
        this.width = rectangle.width;
    }

    public static void main(String[] args) {

    }
}
