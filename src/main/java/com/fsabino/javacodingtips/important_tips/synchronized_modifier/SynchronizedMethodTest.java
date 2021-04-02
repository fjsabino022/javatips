package com.fsabino.javacodingtips.important_tips.synchronized_modifier;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.Test;

public class SynchronizedMethodTest {

	@Test
	public void givenMultiThread_whenNonSyncMethod() throws InterruptedException {
	    ExecutorService service = Executors.newFixedThreadPool(3);
	    SynchronizedMethods summation = new SynchronizedMethods();

	    IntStream.range(0, 1000)
	      .forEach(count -> service.submit(summation::calculate));
	    service.awaitTermination(1000, TimeUnit.MILLISECONDS);

		/*
		 * If we would execute this serially, the expected output would be 1000, but our
		 * multi-threaded execution fails almost every time with an inconsistent actual
		 * output e.g.:
		 * 
		 * java.lang.AssertionError: expected:<1000> but was:<965> at
		 * org.junit.Assert.fail(Assert.java:88) at
		 * org.junit.Assert.failNotEquals(Assert.java:834) ...
		 */
	    assertEquals(1000, summation.getSum());
	}
	
	@Test
	public void givenMultiThread_whenMethodSync() throws InterruptedException {
	    ExecutorService service = Executors.newFixedThreadPool(3);
	    SynchronizedMethods method = new SynchronizedMethods();

	    IntStream.range(0, 1000)
	      .forEach(count -> service.submit(method::synchronisedCalculate));
	    service.awaitTermination(1000, TimeUnit.MILLISECONDS);

	    assertEquals(1000, method.getSum());
	}
	
	@Test
	public void givenMultiThread_whenBlockSync() throws InterruptedException {
	    ExecutorService service = Executors.newFixedThreadPool(3);
	    SynchronizedMethods synchronizedBlocks = new SynchronizedMethods();

	    IntStream.range(0, 1000)
	      .forEach(count -> 
	        service.submit(synchronizedBlocks::performSynchronisedTask));
	    service.awaitTermination(100, TimeUnit.MILLISECONDS);

	    assertEquals(1000, synchronizedBlocks.getSum());
	}
}
