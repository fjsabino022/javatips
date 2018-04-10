package javatips.fsabino.collections_framework.collection.List;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

	public static void main(String[] args) {
		
		/* Linked List Declaration */
		List<String> linkedlist = new LinkedList<String>();

		/*
		 * add(String Element) is used for adding the elements to the linked list
		 */
		linkedlist.add("Item1");
		linkedlist.add("Item5");
		linkedlist.add("Item3");
		linkedlist.add("Item6");
		linkedlist.add("Item2");

		/* Display Linked List Content */
		System.out.println("Linked List Content: " + linkedlist);

		/* This is how to get and set Values */
		Object firstvar = linkedlist.get(0);
		System.out.println("First element: " + firstvar);
		linkedlist.set(0, "Changed first item");
		Object firstvar2 = linkedlist.get(0);
		System.out.println("First element after update by set method: " + firstvar2);
		System.out.println("Linked List Content: " + linkedlist);

		/* Add to a Position and remove from a position */
		linkedlist.add(0, "Newly added item");
		linkedlist.remove(2);
		System.out.println("Final Content: " + linkedlist);
	}

}
