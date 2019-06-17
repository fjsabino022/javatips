package com.fsabino.javacodingtips.patterns_of_design.structural.decorator;

public class Model extends Vehicle {

	private String nombre;
	private int precio;
	
	public Model(String nombre, int precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	@Override
	public String getDescripcion() {
		return this.nombre;
	}

	@Override
	public int getPrecio() {
		return this.precio;
	}
}
