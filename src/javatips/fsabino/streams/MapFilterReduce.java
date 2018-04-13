package javatips.fsabino.streams;

import java.util.ArrayList;
import java.util.List;

public class MapFilterReduce {

	public static void main(String[] args) {

		List<Person> people = new ArrayList<>();
		people.add(new Person("Franco", 28));
		people.add(new Person("Augusto", 12));
		people.add(new Person("Malena", 21));
		people.add(new Person("Tomas", 22));
		people.add(new Person("David", 35));

		// a first way of writing it (show the age)
		people.stream() 						// Stream<Person>
				.map(person -> person.getAge()) // Stream<Integer> --> map change type of a stream
				.filter(age -> age > 20) 		// Stream<Integer>
				.forEach(System.out::println);

		// a first way of writing it (show each person)
		people.stream() 								// Stream<Person>
				.filter(person -> person.getAge() > 20) // Stream<Person> --> filter no change type of a stream
				.forEach(System.out::println); 			// ---> for each doesnt return anything.

		// we can show the partial results
		people.stream() 						// Stream<Person>
				.map(person -> person.getAge()) // Stream<Integer> --> map changes type of a stream from Stream<Person> TO Stream<Integer>
				.peek(System.out::println)      // Peek allows to show partial results! Created for debbuger propose. It is an intermediate operation.
				.filter(age -> age > 20) 		// Stream<Integer>
				.forEach(System.out::println);  // for each is a terminate operation.
		
		// skip and limit method.
		people.stream() 	
		.skip(1) 			// skip first element
		.limit(3)			// limit next three elements
		.filter(person -> person.getAge() > 20) 
		.forEach(System.out::println); 
		
	}

}
