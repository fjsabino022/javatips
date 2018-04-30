package javatips.fsabino.patterns_of_design.structural.flyweight.pluralsight;

import java.util.HashMap;
import java.util.Map;

public class Catalog {
	private Map<String, Item> map = new HashMap<String, Item>();
	
	// factory method
	public Item lookUp (String numberOrder) {
		if (!map.containsKey(numberOrder)) {
			map.put(numberOrder, new Item(numberOrder));
		}
		return map.get(numberOrder);
	}
	
	public int totalItems() {
		return map.size();
	}
}
