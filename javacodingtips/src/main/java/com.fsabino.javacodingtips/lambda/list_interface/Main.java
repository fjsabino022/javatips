package com.fsabino.javacodingtips.lambda.list_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.fsabino.javacodingtips.lambda.Person;

public class Main {

	public static void main(String[] args) {
		
		String name1 = "Palabra 1";
		String name2 = "Palabra 2";
		String name3 = "Palabra 3";
		String name4 = "Palabra 4";
		String name5 = "Palabra 5";
		String name6 = "Palabra 6";
		
		Person p1 = new Person("Franco", 22);
		Person p2 = new Person("Juan Pablo", 25);
		Person p3 = new Person("David", 35);
		Person p4 = new Person("Agustin", 36);
		Person p5 = new Person("Belen", 24);
		Person p6 = new Person("Tomas", 22);
		
		List<Person> listPeople = new ArrayList<Person>(Arrays.asList(p1, p2, p3, p4, p5, p6));
		List<String> listString = new ArrayList<String>(Arrays.asList(name1, name2, name3, name4, name5, name6));
		
		// List - removeif 
		listPeople.removeIf((person) -> person.getAge() == 25);
			
		// List - replaceAll
		listPeople.replaceAll( person -> new Person(person.getName().toUpperCase(), person.getAge()));
		
		// List - sort (by age)
		listPeople.sort(Comparator.comparing(Person::getAge));
		
		// List - forEach - propiedad de objeto 
		listPeople.forEach((person) -> System.out.println(person.getName()));
		
		
		// List - forEach - llamada por referencia
		listString.forEach(System.out::println);
	
		// List - sort (by age - desc)
		listPeople.sort(Comparator.comparing(Person::getAge).reversed());
		
		// List - forEach - propiedad de objeto 
		listPeople.forEach((person) -> System.out.println(person.getName()));
				
	}

}
