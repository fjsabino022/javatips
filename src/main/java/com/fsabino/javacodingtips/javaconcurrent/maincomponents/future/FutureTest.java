package com.fsabino.javacodingtips.javaconcurrent.maincomponents.future;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTest {

    private SquareCalculator subject = new SquareCalculator();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void given_numberToCalculate_when_getFuture_then_theResultShouldBeReturned() throws InterruptedException {
        // given
        Integer numberToCalculate = 10;

        // when
        Future<Integer> future = subject.calculate(numberToCalculate);

        while (future.isDone() == false) {
            System.out.println("Calculating...");
            Thread.sleep(300);
        }

        Integer result = null;
        try {
            /**
             * The method get() will block the execution until the task is complete.
             * But we don't have to worry about that since our example only get to the point where get() is called after making sure that the task is finished.
             * So, in this scenario, future.get() will always return immediately.
             */
            result = future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // then
        assertThat(result, is(100));
    }

    @Test
    public void given_numberToCalculate_when_getFuture_then_theExceptionIsThrown() throws InterruptedException, ExecutionException, TimeoutException {
        // given
        Integer numberToCalculate = 10;

        // when & then
        Future<Integer> future = subject.calculate(numberToCalculate);

        exception.expect(TimeoutException.class);

        /**
         * The difference between get(long, TimeUnit) and get(), is that the former will throw a TimeoutException
         * if the task doesn't return before the specified timeout period.
         */
        future.get(500L, TimeUnit.MILLISECONDS);
    }
}
