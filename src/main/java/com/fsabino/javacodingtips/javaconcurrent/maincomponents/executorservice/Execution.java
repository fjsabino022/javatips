package com.fsabino.javacodingtips.javaconcurrent.maincomponents.executorservice;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/*
 * ExecutorService is a complete solution for asynchronous processing.
 * It manages an in-memory queue and schedules submitted tasks based on thread availability.
 * To use ExecutorService, we need to create one Runnable class.
 *
 * https://www.baeldung.com/java-executor-service-tutorial
 * */
public class Execution {

    private static final Logger log = LoggerFactory.getLogger(Execution.class);

    @Test
    public void given_ExecutorService_when_Shutdown_allasksAreExecuted() {

        // thread-pool with 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Callable<String>> tasks = ImmutableList.<Callable<String>>builder()
                .add(new Task())
                .add(new Task())
                .add(new Task())
                .add(new Task())
                .add(new Task())
                .build();

        List<Future<String>> result = Lists.newArrayList();
        try {
             result = executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The shutdown() method doesn't cause immediate destruction of the ExecutorService.
        // It will make the ExecutorService stop accepting new tasks and shut down after all running threads finish their current work.
        executor.shutdown();
        assertThat(result, hasSize(5));
    }

    @Test
    public void given_ExecutorService_when_ShutdownNow_NOTallTasksAreExecuted() {

        // thread-pool with 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable taskToInterrupt = () -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    log.info("interrupted");
                    break;
                }
            }
        };
        Runnable taskNotInterrupt = () -> {
            while (true) {
                log.info("Never interrupted");
            }
        };

        // first 3 tasks in the pool
        executor.submit(taskNotInterrupt);
        executor.submit(taskToInterrupt);
        executor.submit(taskNotInterrupt);

        // these cannot be executed because the pool is full
        executor.submit(taskNotInterrupt);
        executor.submit(taskNotInterrupt);
        executor.submit(taskNotInterrupt);
        executor.submit(taskNotInterrupt);

        // The shutdownNow() method tries to destroy the ExecutorService immediately,
        // but it doesn't guarantee that all the running threads will be stopped at the same time.
        // This method returns a list of tasks that are waiting to be processed.
        // t is up to the developer to decide what to do with these tasks.
        //

        // @see https://stackoverflow.com/questions/11520189/difference-between-shutdown-and-shutdownnow-of-executor-services
        // ** shutdown() will just tell the executor service that it can't accept new tasks,
        //  but the already submitted tasks continue to run
        // ** shutdownNow() will do the same AND will try to cancel the already submitted tasks by
        // interrupting the relevant threads.
        // Note that if your tasks ignore the interruption,
        // shutdownNow will behave exactly the same way as shutdown.
        List<Runnable> notExecutedTasks = executor.shutdownNow();
        assertThat(notExecutedTasks, hasSize(4));
    }
}
