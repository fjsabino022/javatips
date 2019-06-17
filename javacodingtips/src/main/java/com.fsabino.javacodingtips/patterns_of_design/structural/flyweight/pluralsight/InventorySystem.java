package com.fsabino.javacodingtips.patterns_of_design.structural.flyweight.pluralsight;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventorySystem {
	public final Catalog c = new Catalog();
	private final List<Order> orderes = new CopyOnWriteArrayList<Order>();
	
	void takeOrder (String itemname, int orderNmber) {
		Item i = c.lookUp(itemname);
		Order o = new Order(orderNmber, i);
		orderes.add(o);
	}
	
	void processOrder() {
		for (Order order : orderes) {
			order.processOrder();
			orderes.remove(order);
		}
	}
	
	String report() {
		return "Total de items: " + c.totalItems();
	}
}
