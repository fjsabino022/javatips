package javatips.fsabino.streams.FlatMapStreamOfNumber;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class StreamsOfNumbers {

	public static void main(String[] args) throws IOException {

		Set<String> shakespeareWord = Files.lines(Paths.get(
				"/home/fsabino/repositories/javatips/src/javatips/fsabino/streams/FlatMapStreamOfNumber/words.shakespeare.txt"))
				.map(word -> word.toLowerCase()).collect(Collectors.toSet());

		Set<String> scrabbleWord = Files.lines(Paths
				.get("/home/fsabino/repositories/javatips/src/javatips/fsabino/streams/FlatMapStreamOfNumber/ospd.txt"))
				.map(word -> word.toLowerCase()).collect(Collectors.toSet());

		System.out.println("words of shakespeare: " + shakespeareWord.size());
		System.out.println("words of scrabble: " + scrabbleWord.size());

		final int[] scrabbleENScore = {
			 // a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p,  q, r, s, t, u, v, w, x, y, z
				1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };

		Function<String, Integer> score = word -> word.chars().map(letter -> scrabbleENScore[letter - 'a']).sum();

		ToIntFunction<String> intScore = word -> word.chars().map(letter -> scrabbleENScore[letter - 'a']).sum();

		System.out.println("Score of hello: " + intScore.applyAsInt("hello"));
		
		String word = shakespeareWord.stream()
			.filter(palabra -> scrabbleWord.contains(palabra))
			.max(Comparator.comparing(score))
			.get();
		
		System.out.println("Best World: "+  word);
		
		IntSummaryStatistics summaryStatistics = shakespeareWord.stream()
				.filter(scrabbleWord::contains)
				.mapToInt(intScore)
				.summaryStatistics();
		
		System.out.println("Summary: "+ summaryStatistics);
	}

}
