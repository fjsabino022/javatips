package com.fsabino.javacodingtips.patterns_of_design.structural.decorator.pluralsight;

public class SimpleSandwich implements Sandwich {

	@Override
	public String make() {
		return "Bread";
	}
}
