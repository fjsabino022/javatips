package com.fsabino.javacodingtips.patterns_of_design.structural.facade.shapes;

public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("CIRCLE");
	}
}
