package com.fsabino.javacodingtips.patterns_of_design.structural.decorator.pluralsight;

public abstract class SandwichDecorator implements Sandwich {

	protected Sandwich sandwich;
	
	public SandwichDecorator(Sandwich s) {
		this.sandwich = s;
	}
	
	@Override
	public String make() {
		return sandwich.make();
	}

}
