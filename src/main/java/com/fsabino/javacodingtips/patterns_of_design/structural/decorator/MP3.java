package com.fsabino.javacodingtips.patterns_of_design.structural.decorator;

public class MP3 extends ExtrasDecorator {

	private final String name = "MP3";
	private final int precio = 333;
	
	public MP3(Vehicle v) {
		super(v);
	}
	
	@Override
	public String getDescripcion() {
		return this.getVehicle().getDescripcion() + " " + this.name;
	}

	@Override
	public int getPrecio() {
		return this.getVehicle().getPrecio() + this.precio;
	}
}
