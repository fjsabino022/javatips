package com.fsabino.javacodingtips.javaconcurrent.maincomponents.executorservice;

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<String> {

    private static final Logger log = LoggerFactory.getLogger(Task.class);

    @Override
    public String call() {
        String threadName = Thread.currentThread().getName();
        long threadId = Thread.currentThread().getId();
        int sleepTime = RandomUtils.nextInt(7, 10);
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            log.error("InterruptedException thread={}", threadName, e);
        }

        log.info("threadId={} - threadName={} - sleepTime={}", threadId, threadName, sleepTime);
        return String.format("threadId=%s - threadName=%s - sleepTime=%s", threadId, threadName, sleepTime);
    }
}
