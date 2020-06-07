package com.fsabino.javacodingtips.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TerminalOperations {

	public static void main(String[] args) {

		List<Person> people = new ArrayList<>();
		people.add(new Person("Franco", 28));
		people.add(new Person("Augusto", 12));
		people.add(new Person("Malena", 21));
		people.add(new Person("Tomas", 22));
		people.add(new Person("David", 35));

		// any match
		boolean any = people.stream()
				.anyMatch(person -> person.getAge() > 30); // terminal operation, devuelve true if there is one
		System.out.println("Any Match: "+ any);
		
		// all match
		boolean all = people.stream()
				.allMatch(person -> person.getAge() > 30); // terminal operation, devuelve true if all elements math the predicate
		System.out.println("All Match: "+ all);
		
		// none match
		boolean none = people.stream()
				.noneMatch(person -> person.getAge() > 30); // terminal operation, devuelve true if any element match the predicate
		System.out.println("None Match: "+ none);
		
		// find first
		Optional<Person> firstPerson = people.stream().filter(person -> person.getAge() > 30).findFirst();
		System.out.println("Find First: "+ firstPerson);
		
	}
}
