package com.fsabino.javacodingtips.patterns_of_design.structural.composite;

import java.util.Iterator;

public class MenuComposite extends MenuComponent {

	public MenuComposite (String name, String url) {
		this.name = name;
		this.url = url;
	}
	
	@Override
	public MenuComponent add (MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
		return menuComponent;
	}
	
	@Override
	public MenuComponent remove (MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
		return menuComponent;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(print(this));
		
		Iterator<MenuComponent> itr = menuComponents.iterator();
		while (itr.hasNext()) {
			MenuComponent menuComponent = (MenuComponent) itr.next();
			sb.append(menuComponent.toString());
		}
		
		return sb.toString();
	}
}
