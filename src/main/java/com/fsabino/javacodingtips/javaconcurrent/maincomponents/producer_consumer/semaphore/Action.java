package com.fsabino.javacodingtips.javaconcurrent.maincomponents.producer_consumer.semaphore;

public class Action {
    static void producerLog(String message) {
        System.out.printf("Thread: %s. PRODUCER: %s \n", Thread.currentThread().getName(), message);
    }
    static void consumerLog(String message) {
        System.out.printf("Thread: %s. CONSUMER: %s \n", Thread.currentThread().getName(), message);
    }
}
