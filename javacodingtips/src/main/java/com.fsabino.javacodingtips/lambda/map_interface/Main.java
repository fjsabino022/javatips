package com.fsabino.javacodingtips.lambda.map_interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fsabino.javacodingtips.lambda.Person;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Person p1 = new Person("Franco", 22);
		Person p2 = new Person("Juan Pablo", 25);
		Person p3 = new Person("David", 35);
		Person p4 = new Person("Agustin", 36);
		Person p5 = new Person("Belen", 24);
		Person p6 = new Person("Tomas", 22);

		City newYork = new City("Nueva York");
		City Barcelona = new City("Barcelona");
		City paris = new City("Paris");
		City shangai = new City("Shangai");
		
		Map<City, List<Person>> city_people = new HashMap<City, List<Person>>();
		
		// what happen if i ask for a city => the result will be null
		System.out.println("People from Paris: "+ city_people.get(paris));
		
		// Map - getOrDefault
		System.out.println("People from Paris: "+ city_people.getOrDefault(paris, Collections.EMPTY_LIST));
	
		// Map - putIfAbsent
		city_people.putIfAbsent(paris, new ArrayList<Person>());
		city_people.get(paris).add(p1);
		
		// Map - computeIfAbsent
		city_people.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p2);
		city_people.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p3);
		System.out.println("People from New York: "+ city_people.getOrDefault(newYork, Collections.EMPTY_LIST));
		
		System.out.println("------------------------");
		
		Map<City, List<Person>> map1 = new HashMap<City, List<Person>>();
		map1.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p1);
		map1.computeIfAbsent(shangai, city -> new ArrayList<>()).add(p2);
		map1.computeIfAbsent(shangai, city -> new ArrayList<>()).add(p3);
		
		System.out.println("Map 1 -------------");
	
		// Map - forEach
		map1.forEach((city, people) -> System.out.println(city+ ": "+ people));

		Map<City, List<Person>> map2 = new HashMap<City, List<Person>>();
		map2.computeIfAbsent(shangai, city -> new ArrayList<>()).add(p4);
		map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p4);
		map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p5);
		
		System.out.println("Map 2 -------------");
		
		// Map - forEach
		map2.forEach((city, people) -> System.out.println(city+ ": "+ people));
		
		map2.forEach(
				(city, people) -> {
					map1.merge(
							city, people,
							(peopleFromMap1, peopleFromMap2) -> {
								peopleFromMap1.addAll(peopleFromMap2);
								return peopleFromMap1;
							}
					);
					
				}
		);
		
		System.out.println("Map 2 merge to Map 1 -------------");
		map1.forEach((city, people) -> System.out.println(city+ ": "+ people));
		
	}
}
