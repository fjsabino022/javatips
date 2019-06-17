package com.fsabino.javacodingtips.patterns_of_design.structural.decorator;

public abstract class ExtrasDecorator extends Vehicle {

	private Vehicle vehicle;
	
	public ExtrasDecorator(Vehicle v) { 
		this.vehicle = v;
	}
	
	public Vehicle getVehicle() {
		return this.vehicle;
	}
}
