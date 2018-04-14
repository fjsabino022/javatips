package javatips.fsabino.streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Examples {

	public static void main(String[] args) {
		
		// first example
		List<Integer> list = Arrays.asList(0,1,2,3,4);
		Stream<Integer> stream = list.stream();
		Stream<Integer> streamof = Stream.of(0,1,2,3,4);
		stream.forEach(System.out::println);
		streamof.forEach(System.out::println);
		
		// second example
		Stream<String> listStream = Stream.generate(() -> "one");
		listStream.limit(4).forEach(System.out::println);
		
		// third example
		Stream<String> listIterate = Stream.iterate("+", s -> s + "+");
		listIterate.limit(4).forEach(System.out::println);
		
		// four example
		IntStream streamOfInt =  ThreadLocalRandom.current().ints();
		streamOfInt.limit(4).forEach(System.out::println);
	}

}
