package com.fsabino.javacodingtips.patterns_of_design.structural.decorator;

public class FrenosABS extends ExtrasDecorator {

	private final String name = "FRENOS ABS";
	private final int precio = 500;
	
	public FrenosABS(Vehicle v) {
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
