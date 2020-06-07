package com.fsabino.javacodingtips.javaconcurrent.maincomponents.executorservice;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        /*
        * ExecutorService is a complete solution for asynchronous processing.
        * It manages an in-memory queue and schedules submitted tasks based on thread availability.
        * To use ExecutorService, we need to create one Runnable class.
        * */
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            new Task().run();
        });
        executor.submit(() -> {
            try {
                Thread.sleep(6000);
                System.out.println("Finished Task 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Force Task 1");
            }
        });
        executor.submit(() -> {
            try {
                Thread.sleep(6000);
                System.out.println("Finished Task 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Force Task 2");
            }
        });
        executor.submit(() -> {
            try {
                Thread.sleep(6000);
                System.out.println("Finished Task 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Force Task 2");
            }
        });

        // finaliza automaticamente las tareas que se estan ejecutando y devuelve lista de las que no se han ejecutado aun
        // List<Runnable> runnables =  executor.shutdownNow();

        // frena/apaga el executor cuando todas las tareas que tiene asignadas finalizan
        executor.shutdown();

        try {
            // de acuerdo al tiempo especificado te determina si se ejecutaron todas las tareas que tiene asignado el executor.
            boolean finished = executor.awaitTermination( 6000, TimeUnit.MILLISECONDS );

            System.out.println("All Task were finished? "+ finished);

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Force All Task");
        }
    }
}
