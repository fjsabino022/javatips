package com.fsabino.javacodingtips.threadsafe.semaphore;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SemaphoreAndMutexTest {

    @Test
    public void given_IHaveMultipleThreads_when_weDontWait_then_TheThreadsAreBlocked() throws InterruptedException {
        // given when
        final int threadsNumber = 5;
        final SemaphoreAndMutex semaphoreAndMutex = new SemaphoreAndMutex();
        final ExecutorService executor = Executors.newFixedThreadPool(threadsNumber);
        IntStream.range(0, threadsNumber)
                .forEach(number -> executor.execute(() -> {
                    try {
                        semaphoreAndMutex.increase();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }));
        Thread.sleep(500);
        executor.shutdown();

        // then
        assertTrue(semaphoreAndMutex.hasQueuedThreads());
    }

    @Test
    public void given_IHaveMultipleThreads_when_weWait_then_TheThreadsAreNotBlocked() throws InterruptedException {
        // given when
        final int threadsNumber = 5;
        final SemaphoreAndMutex semaphoreAndMutex = new SemaphoreAndMutex();
        final ExecutorService executor = Executors.newFixedThreadPool(threadsNumber);
        IntStream.range(0, threadsNumber)
                .forEach(number -> executor.execute(() -> {
                    try {
                        semaphoreAndMutex.increase();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }));
        Thread.sleep(500);
        executor.shutdown();

        // then
        assertTrue(semaphoreAndMutex.hasQueuedThreads());
        Thread.sleep(5000);
        assertFalse(semaphoreAndMutex.hasQueuedThreads());
    }
}
