package com.fsabino.javacodingtips.streams.spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class PersonSpliterator implements Spliterator<Person> {

	public final Spliterator<String> lineSpliterator;
	private String name;
	private String city;
	private int age;
	
	public PersonSpliterator(Spliterator<String> lineSpliterator) {
		this.lineSpliterator = lineSpliterator;
	}
	
	@Override
	public int characteristics() {
		return lineSpliterator.characteristics();
	}

	@Override
	public long estimateSize() {
		return lineSpliterator.estimateSize() / 3;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Person> action) {
		if (this.lineSpliterator.tryAdvance(line -> this.name = line) &&
			this.lineSpliterator.tryAdvance(line -> this.age = Integer.parseInt(line)) &&
			this.lineSpliterator.tryAdvance(line -> this.city = line)) {
			Person p = new Person(name, age, city);
			action.accept(p);
			return true;
		}
		return false;
	}

	@Override
	public Spliterator<Person> trySplit() {
		return null;
	}
}
