package com.fsabino.javacodingtips.patterns_of_design.structural.facade;

import com.fsabino.javacodingtips.patterns_of_design.structural.facade.shapes.Circle;
import com.fsabino.javacodingtips.patterns_of_design.structural.facade.shapes.Rectangle;
import com.fsabino.javacodingtips.patterns_of_design.structural.facade.shapes.Shape;
import com.fsabino.javacodingtips.patterns_of_design.structural.facade.shapes.Square;

public class ShapeFacade {
	
	private static ShapeFacade instance = new ShapeFacade();
	
	private Shape circle;
	private Shape rectangle;
	private Shape square;
	
	private ShapeFacade () {
		this.circle = new Circle();
		this.rectangle = new Rectangle();
		this.square = new Square();
	}
	
	public static ShapeFacade getInstance() {
		return instance;
	}
	
	public Shape getCircle() {
		return this.circle;
	}
	
	public Shape getRectangle() {
		return this.rectangle;
	}
	
	public Shape getSquare() {
		return this.square;
	}
}
