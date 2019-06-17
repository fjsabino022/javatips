package com.fsabino.javacodingtips.lambda;

import java.util.Map;
import java.util.TreeMap;

/**
 * Utilizamos una lambda para procesar valores, a través de un consumidor, que concatena los valores enteros que se obtienen del mapa.
 * */
public class Consummer {

	public static void main(String[] args) {
		Map<String, Integer> map = new TreeMap<>();
		map.put("Franco", 1);
		map.put("Jesus", 2);
		map.put("Sabino", 3);

		StringBuilder stringBuilder = new StringBuilder();
		map.forEach((letter, number) -> stringBuilder.append(letter.concat(String.valueOf(number))));
		System.out.println(stringBuilder.toString());
	}
}
