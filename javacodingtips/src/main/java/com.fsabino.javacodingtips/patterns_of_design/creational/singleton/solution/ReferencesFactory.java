package com.fsabino.javacodingtips.patterns_of_design.creational.singleton.solution;

import java.util.HashMap;
import java.util.Map;

public class ReferencesFactory {
	
	// static field private (creacion temprana)
	private static ReferencesFactory instance = new ReferencesFactory();
	private Map<String, Integer> references;
    private int reference;

    // private contructor
    private ReferencesFactory() {
        this.references = new HashMap<>();
        this.reference = 0;
    }
    
    // method static return instance
    public static ReferencesFactory getInstance() {
 
    	return instance;
    }

    public int getReference(String key) {
        return references.computeIfAbsent(key, k -> reference++);
    }

    public void removeReference(String key) {
        this.references.remove(key);
    }
}
