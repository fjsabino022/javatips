package com.fsabino.javacodingtips.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Streams {

	
	public static void main(String[] args) {
		
		// stream limit
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		filtered.stream().forEach(System.out::println);
		
		// foreach
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
		
		// map
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
		squaresList.stream().forEach(System.out::println);
		
		// filter
		List<String> stringsFilter = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		int count = (int) stringsFilter.stream().filter(string -> string.isEmpty()).count();
		System.out.println("Cantidad: "+ count);
		
		// sorted
		Random randomlist = new Random();
		randomlist.ints().limit(10).sorted().forEach(System.out::println);
		
		// parallel 
		List<String> stringsParallel = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		int countParallel = (int) stringsParallel.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println("Cantidad: "+ countParallel);
		
		// Collectors
		List<String >stringsCollectors = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filteredCollectors = stringsCollectors.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("Filtered List: " + filteredCollectors);
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);
		
		// Statistics
		List numbersStatistics = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		IntSummaryStatistics stats = numbersStatistics.stream().mapToInt((x) -> (int) x).summaryStatistics();
		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());
	}

}
