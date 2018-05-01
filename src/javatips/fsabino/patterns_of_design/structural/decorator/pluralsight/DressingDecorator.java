package javatips.fsabino.patterns_of_design.structural.decorator.pluralsight;

public class DressingDecorator extends SandwichDecorator {

	public DressingDecorator(Sandwich s) {
		super(s);
	}

	@Override
	public String make() {
		return sandwich.make() + addDressing();
	}

	private String addDressing() {
		return " Tiramisu";
	}
}
