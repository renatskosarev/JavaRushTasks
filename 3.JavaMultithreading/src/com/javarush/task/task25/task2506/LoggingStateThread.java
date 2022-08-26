package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

    private Thread target;
    private Thread.State oldState;

    public LoggingStateThread(Thread thread) {
        target = thread;
    }

    public void run() {
        while (target.getState() != State.TERMINATED) {
            Thread.State tempState = target.getState();
            if (tempState != oldState) {
                System.out.println(tempState);
                oldState = tempState;
            }
        }
        System.out.println(target.getState());
    }
}
