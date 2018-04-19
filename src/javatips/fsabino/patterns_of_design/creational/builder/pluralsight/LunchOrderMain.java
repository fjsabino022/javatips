package javatips.fsabino.patterns_of_design.creational.builder.pluralsight;

public class LunchOrderMain {

	public static void main(String[] args) {
		
		// create a new instance of builder
		LunchOrder.Builder builder = new LunchOrder.Builder();
		LunchOrder lunchOrder =  builder.setBread("Pan de marinucci").setMeat("La mejor carne").build();
		
		System.out.println(lunchOrder.getBread());
		System.out.println(lunchOrder.getMeat());
	}
}
