package javatips.fsabino.streams.FlatMapStreamOfNumber;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FlatMapExamples {
	
	public static void main(String[] args) throws IOException {
		
		Stream<String> stream1 = Files.lines(Paths.get(
				"/home/fsabino/repositories/javatips/src/javatips/fsabino/streams/FlatMapStreamOfNumber/TomSawyer_01.txt"));
		Stream<String> stream2 = Files.lines(Paths.get(
				"/home/fsabino/repositories/javatips/src/javatips/fsabino/streams/FlatMapStreamOfNumber/TomSawyer_02.txt"));
		Stream<String> stream3 = Files.lines(Paths.get(
				"/home/fsabino/repositories/javatips/src/javatips/fsabino/streams/FlatMapStreamOfNumber/TomSawyer_03.txt"));
		Stream<String> stream4 = Files.lines(Paths.get(
				"/home/fsabino/repositories/javatips/src/javatips/fsabino/streams/FlatMapStreamOfNumber/TomSawyer_04.txt"));
		
		// stream of stream
		Stream<Stream<String>> streamOfStream = Stream.of(stream1, stream2, stream3, stream4);
		
		// flatMap
		Stream<String> streamOfLines = streamOfStream.flatMap(stream -> stream); // stream -> stream ==> es la funcion de Identity. Function.identity()
		
		// function for use on flapMap
		Function<String, Stream<String>> lineSpliter = line -> Pattern.compile(" ").splitAsStream(line);
		
		Stream<String> streamOfWord = streamOfLines.flatMap(lineSpliter)
										.map(word -> word.toLowerCase())
										.filter(word -> word.length() == 4)
										.distinct();
		System.out.println("Cantidad de palabras distintas de tamaño 4: "+ streamOfWord.count());
	}
}
