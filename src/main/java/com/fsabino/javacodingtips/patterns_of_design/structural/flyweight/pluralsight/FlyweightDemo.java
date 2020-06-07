package com.fsabino.javacodingtips.patterns_of_design.structural.flyweight.pluralsight;

public class FlyweightDemo {

	public static void main(String[] args) {
		InventorySystem is = new InventorySystem();
		is.takeOrder("Lapiz", 23);
		is.takeOrder("Lapiz", 20);
		is.takeOrder("Lapiz", 888);
		is.takeOrder("Lapiz", 29);
		is.takeOrder("Acuarela", 674);
		is.takeOrder("Acuarela", 31);
		is.takeOrder("Acuarela", 891);
		is.takeOrder("Acuarela", 33);
		is.takeOrder("Frazada", 23);
		is.takeOrder("Frazada", 1);
		is.takeOrder("Frazada", 2);
		is.takeOrder("Frazada", 4);
		is.processOrder();
		System.out.println("Cantidad items "+ is.report());
	}

}
