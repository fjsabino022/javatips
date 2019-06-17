package com.fsabino.javacodingtips.collections_framework.collection.Set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ConvertHashSettoTreeSet {

	/**
	 * HashSet vs TreeSet 
	 * 
	 * 1) HashSet gives better performance (faster) than TreeSet
	 * for the operations like add, remove, contains, size etc. HashSet offers
	 * constant time cost while TreeSet offers log(n) time cost for such operations.
	 * 
	 * 2) HashSet does not maintain any order of elements while TreeSet elements are
	 * sorted in ascending order by default.
	 * 
	 * Similarities:
	 * 
	 * 1) Both HashSet and TreeSet does not hold duplicate elements, which means
	 * both of these are duplicate free.
	 * 
	 * 2) If you want a sorted Set then it is better to add elements to HashSet and
	 * then convert it into TreeSet rather than creating a TreeSet and adding
	 * elements to it.
	 * 
	 * 3) Both of these classes are non-synchronized that means they are not
	 * thread-safe and should be synchronized explicitly when there is a need of
	 * thread-safe operations.
	 * 
	 */
	public static void main(String[] args) {
		// Create a HashSet
		Set<String> hset = new HashSet<String>();

		// add elements to HashSet
		hset.add("Element1");
		hset.add("Element2");
		hset.add("Element3");
		hset.add("Element4");

		// Displaying HashSet elements
		System.out.println("HashSet contains: " + hset);

		// Creating a TreeSet of HashSet elements
		Set<String> tset = new TreeSet<String>(hset);

		// Displaying TreeSet elements
		System.out.println("TreeSet contains: ");
		for (String temp : tset) {
			System.out.println(temp);
		}
	}
}
