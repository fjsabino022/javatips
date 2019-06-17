package com.fsabino.javacodingtips.patterns_of_design.creational.prototype.solution;

public class PrototypeDemo {

	public static void main(String[] args) {
		
		Registry registry = new Registry();
		Movie movie = (Movie) registry.createItem("Movie");
		movie.setTitle("Creational Pattern in Java");

		// clonado profundo, hace una nueva instancia
		System.out.println(movie);
		System.out.println(movie.getRuntime());
		System.out.println(movie.getTitle());
		System.out.println(movie.getUrl());
		
		Movie anotherMovie = (Movie) registry.createItem("Movie");
		anotherMovie.setTitle("Gong of Four");
		
		// clonado profundo, hace una nueva instancia
		System.out.println(anotherMovie);
		System.out.println(anotherMovie.getRuntime());
		System.out.println(anotherMovie.getTitle());
		System.out.println(anotherMovie.getUrl());
	}
}
