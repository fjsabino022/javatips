package com.fsabino.javacodingtips.streams.spliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CreatingSpliterator {

	public static void main(String[] args) {
		
		Path p = Paths.get("/home/fsabino/repositories/javatips/src/javatips/fsabino/streams/spliterator/people.txt");
		
		try {
			Stream<String> lines = Files.lines(p);
			Spliterator<String> lineSpliterator =  lines.spliterator();
			
			Spliterator<Person> peopleSpliterator = new PersonSpliterator(lineSpliterator);
			
			Stream<Person> people = StreamSupport.stream(peopleSpliterator, true);
			people.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
