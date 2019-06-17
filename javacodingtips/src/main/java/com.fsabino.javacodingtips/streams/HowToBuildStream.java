package com.fsabino.javacodingtips.streams;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HowToBuildStream {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
		// an empty stream
		Stream.empty();
		
		// a singleton Stream
		Stream.of("one");
		
		// strem with several elements
		Stream.of("one", "two", "three");

		// a constant stream 
		Stream.generate(() -> "one");
		
		// a growing (creciente) stream
		Stream.iterate("+", s -> s + "+");
		
		// a random stream
		ThreadLocalRandom.current().ints();
		
		// a stream on the letters of a String
		IntStream stream = "hello".chars();
		
		// a stream on a regular expression
		Stream<String> words = java.util.regex.Pattern.compile("*").splitAsStream("book");
		
		// a stream on the lines of a text file
		Stream<String> lines = Files.lines(Paths.get(new URI("franco")));
	}

}
