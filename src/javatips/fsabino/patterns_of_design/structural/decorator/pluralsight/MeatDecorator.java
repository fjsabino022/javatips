package javatips.fsabino.patterns_of_design.structural.decorator.pluralsight;

public class MeatDecorator extends SandwichDecorator {

	public MeatDecorator(Sandwich s) {
		super(s);
	}

	public String make() {
		return this.sandwich.make() + addMeat();
	}

	private String addMeat() {
		return " Tiene CARNE";
	}
	
}
