package com.fsabino.javacodingtips.patterns_of_design.creational.singleton;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.fsabino.javacodingtips.patterns_of_design.creational.singleton.solution.ReferencesFactory;

public class SingletonTest {
	@Test
	public void testIsSingleton() {
		ReferencesFactory r1 = ReferencesFactory.getInstance();
		ReferencesFactory r2 = ReferencesFactory.getInstance();
		
		assertSame(r1, r2);
	}

	@Test
	public void testSingletonNotNull() {
		assertNotNull(ReferencesFactory.getInstance());
	}
}
