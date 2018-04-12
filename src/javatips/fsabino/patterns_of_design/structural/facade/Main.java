package javatips.fsabino.patterns_of_design.structural.facade;

public class Main {

	public static void main(String[] args) {
		
		ShapeFacade.getInstance().getCircle().draw();
		ShapeFacade.getInstance().getRectangle().draw();
		ShapeFacade.getInstance().getSquare().draw();
	}

}
