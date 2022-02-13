package com.fsabino.javacodingtips.threadsafe.semaphore;

import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

public class SemaphoreAndMutex {
    private static final Logger LOGGER = Logger.getLogger(SemaphoreAndMutex.class.getName());

    private Semaphore mutex;
    private int count;

    SemaphoreAndMutex() {
        mutex = new Semaphore(1);
        count = 0;
    }

    void increase() throws InterruptedException {
        LOGGER.info("acquire");
        mutex.acquire();

        LOGGER.info("Adding a value in the counter");
        this.count = this.count + 1;

        LOGGER.info("Sleeping 1 second");
        Thread.sleep(1000);

        mutex.release();
        LOGGER.info("released");
    }

    int getCount() {
        return this.count;
    }

    boolean hasQueuedThreads() {
        return mutex.hasQueuedThreads();
    }
}
