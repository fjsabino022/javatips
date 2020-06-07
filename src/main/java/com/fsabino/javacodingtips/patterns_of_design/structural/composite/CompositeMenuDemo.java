package com.fsabino.javacodingtips.patterns_of_design.structural.composite;

public class CompositeMenuDemo {

	public static void main(String[] args) {
		MenuComposite mainMenu = new MenuComposite("Main", "/main");
		MenuItem  safetyMenu = new MenuItem("Safety", "/safety");
		mainMenu.add(safetyMenu);
		
		MenuComposite caimsSubMenu = new MenuComposite("Claims", "/claims");
		mainMenu.add(caimsSubMenu);
		
		MenuItem personalClainMenu = new MenuItem("Personal Claim", "/personalClaim");
		caimsSubMenu.add(personalClainMenu);
		
		System.out.println(mainMenu.toString());
	}

}
