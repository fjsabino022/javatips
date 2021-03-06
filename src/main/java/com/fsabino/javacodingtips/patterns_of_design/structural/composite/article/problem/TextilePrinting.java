package com.fsabino.javacodingtips.patterns_of_design.structural.composite.article.problem;

public class TextilePrinting extends Product {
	
	private String type;

    public TextilePrinting(int id, String reference, String type) {
        super(id, reference);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
