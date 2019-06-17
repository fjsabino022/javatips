package com.fsabino.javacodingtips.patterns_of_design.structural.decorator.pluralsight;

public class DecoratorDemo {

	public static void main(String[] args) {
		Sandwich s = new DressingDecorator(new MeatDecorator(new SimpleSandwich()));
		System.out.println(s.make());
	}
}
