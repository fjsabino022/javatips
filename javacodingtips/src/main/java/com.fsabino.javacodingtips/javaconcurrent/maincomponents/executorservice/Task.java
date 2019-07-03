package com.fsabino.javacodingtips.javaconcurrent.maincomponents.executorservice;

public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Executed Task");
    }
}
