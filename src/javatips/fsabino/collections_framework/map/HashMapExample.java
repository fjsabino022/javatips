package javatips.fsabino.collections_framework.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		/* This is how to declare HashMap */
		Map<Integer, String> hmap = new HashMap<Integer, String>();

		/* Adding elements to HashMap */
		hmap.put(12, 	"Chaitanya");
		hmap.put(2, 	"Rahul");
		hmap.put(7, 	"Singh");
		hmap.put(49, 	"Ajeet");
		hmap.put(3, 	"Anuj");

		/* Display content using Iterator */
		Set set = hmap.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			System.out.print("key is: " + mentry.getKey() + " & Value is: ");
			System.out.println(mentry.getValue());
		}

		/* Get values based on key */
		String var = hmap.get(2);
		System.out.println("Value at index 2 is: " + var);

		/* Remove values based on key */
		hmap.remove(3);
		System.out.println("Map key and values after removal:");
		Set set2 = hmap.entrySet();
		Iterator iterator2 = set2.iterator();
		while (iterator2.hasNext()) {
			Map.Entry mentry2 = (Map.Entry) iterator2.next();
			System.out.print("Key is: " + mentry2.getKey() + " & Value is: ");
			System.out.println(mentry2.getValue());
		}

		//hashmap allows us to add null key
		hmap.put(null, 	"Null value");
		String value = hmap.get(null);

		//replace the value of the same key
		hmap.put(null, 	"Null value 2");
		String value2 = hmap.get(null);

		//hashmap allows us to add null value
		hmap.put(1000, 	null);
		String valueNull = hmap.get(1000);

	}
}
