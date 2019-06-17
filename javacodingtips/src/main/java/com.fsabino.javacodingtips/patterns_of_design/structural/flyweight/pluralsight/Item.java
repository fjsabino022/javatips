package com.fsabino.javacodingtips.patterns_of_design.structural.flyweight.pluralsight;

public class Item {
	private final String name;
	
	public Item(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
