package javatips.fsabino.streams.FlatMapStreamOfNumber;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsOfNumbers {

	public static void main(String[] args) throws IOException {
		
		Set<String> shakespeareWord = Files.lines(Paths.get("/home/fsabino/repositories/javatips/src/javatips/fsabino/streams/FlatMapStreamOfNumber/words.shakespeare.txt"))
										.map(word -> word.toLowerCase())
										.collect(Collectors.toSet());
		
		
		Set<String> scrabbleWord = Files.lines(Paths.get("/home/fsabino/repositories/javatips/src/javatips/fsabino/streams/FlatMapStreamOfNumber/ospd.txt"))
				.map(word -> word.toLowerCase())
				.collect(Collectors.toSet());

		System.out.println("words of shakespeare: "+ shakespeareWord.size());
		System.out.println("words of scrabble: "+ scrabbleWord.size());
	}

}
