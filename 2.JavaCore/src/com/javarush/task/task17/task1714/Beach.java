package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

    }

    @Override
    public synchronized int compareTo(Beach o) {
        int firstIsBetterThanSecond = 0;
        if (this.quality > o.quality) {
            firstIsBetterThanSecond++;
        } else if (this.quality < o.quality) {
            firstIsBetterThanSecond--;
        }

        if (this.distance < o.distance) {
            firstIsBetterThanSecond++;
        } else if (this.distance > o.distance) {
            firstIsBetterThanSecond--;
        }
        if (firstIsBetterThanSecond > 0) return 1;
        if (firstIsBetterThanSecond < 0) return -1;
        return 0;
    }
}
