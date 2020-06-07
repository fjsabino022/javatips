package com.fsabino.javacodingtips.patterns_of_design.structural.decorator;

public class DecoratorDemo {

	public static void main(String[] args) {
		Vehicle v = new Model("AudiA5", 1000);
		
		Vehicle vMP3 = new MP3(v);
		System.out.println("Automovil 1: "+ vMP3.getDescripcion() + " " + vMP3.getPrecio());

		Vehicle vMP3yFRENOS = new FrenosABS(vMP3);
		System.out.println("Automovil 2: "+ vMP3yFRENOS.getDescripcion() + " " + vMP3yFRENOS.getPrecio());
	}
}
