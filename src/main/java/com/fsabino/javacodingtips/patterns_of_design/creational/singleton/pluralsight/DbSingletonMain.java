package com.fsabino.javacodingtips.patterns_of_design.creational.singleton.pluralsight;

public class DbSingletonMain {

	public static void main(String[] args) {
		
		DbSingleton instance = DbSingleton.getInstance();
		DbSingleton anotherInstance = DbSingleton.getInstance();
		
		System.out.println(instance);
		System.out.println(anotherInstance);
		
		
	}

}
