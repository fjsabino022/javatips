package com.fsabino.javacodingtips.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReduceReduction {

	public static void main(String[] args) {
		
		List<Person> people = new ArrayList<>();
		people.add(new Person("Franco", 2));
		people.add(new Person("Augusto", 1));
		people.add(new Person("Malena", 3));
		people.add(new Person("Tomas", 5));
		people.add(new Person("David", 7));
		
		// first version of reduce
		// 0 is the identity element of the sum
		// if the identity element is provided, the result is the same type as the type of the stream
		int sumOfAges = people.stream()
				.map(p -> p.getAge())
				.reduce(0, (p1, p2) -> p1 + p2 );
		System.out.println("Sum of ages:" + sumOfAges);
	
		// 0 is the identity element when all elements are positive.
		int maxPositive = people.stream()
				.map(p -> p.getAge())
				.reduce(0, (p1, p2) -> Integer.max(p1, p2));
		System.out.println("Max of positive elements:" + maxPositive);
		
		// second version of reduce
		// when if i do not provide any identity element to the reduce call, then the result will be wrapped in a Optional
		Optional<Integer> maxSum = people.stream()
				.map(p -> p.getAge())
				.reduce((p1, p2) -> Integer.max(p1 , p2));
		System.out.println("Max of positive elements without identity element:" + maxSum);
		
		// Third version of the reduce method: used in parallel operations
		// I site it here for the sake of completeness 
		// I need three elements: 1- identity element 2- the acumulator 3- the combiner to merge both list									
	}

}
