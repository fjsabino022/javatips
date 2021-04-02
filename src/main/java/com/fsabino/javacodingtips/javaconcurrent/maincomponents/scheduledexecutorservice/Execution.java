package com.fsabino.javacodingtips.javaconcurrent.maincomponents.scheduledexecutorservice;

import java.util.concurrent.*;

class Main {
    public static void main(String[] args) {

        ScheduledExecutorService executorService
                = Executors.newScheduledThreadPool(3);

        Future<String> future = executorService.schedule(() -> {
            // ...
            System.out.println("Executing task 1 - ThreadName= " + Thread.currentThread().getName());
            return "Hello world 1";
        }, 1, TimeUnit.SECONDS);

        Future<String> future2 = executorService.schedule(() -> {
            // ...
            System.out.println("Executing task 2 - ThreadName= " + Thread.currentThread().getName());
            return "Hello world 2";
        }, 2, TimeUnit.SECONDS);

        Future<String> future3 = executorService.schedule(() -> {
            // ...
            System.out.println("Executing task 3 - ThreadName= " + Thread.currentThread().getName());
            return "Hello world 3";
        }, 3, TimeUnit.SECONDS);


        executorService.shutdown();

        ScheduledExecutorService executorService2
                = Executors.newScheduledThreadPool(3);

        executorService2.scheduleAtFixedRate(() -> {
            // ...
            System.out.println("Executing task 4 - ThreadName= " + Thread.currentThread().getName());
        }, 1, 1, TimeUnit.SECONDS);

        executorService2.scheduleAtFixedRate(() -> {
            // ...
            System.out.println("Executing task 5 - ThreadName= " + Thread.currentThread().getName());
        }, 2, 1, TimeUnit.SECONDS);

        try {
            executorService2.awaitTermination(10, TimeUnit.SECONDS);
            executorService2.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
