package javatips.fsabino.patterns_of_design.structural.flyweight.pluralsight;

public class Order {
	private final int orderNumber;
	private final Item item;
	
	public Order (int orderNumber, Item item) {
		this.orderNumber = orderNumber;
		this.item = item;
	}
	
	void processOrder() {
		System.out.println("Order Numer: "+ orderNumber + " Item: " + item.getName());
	}
}
