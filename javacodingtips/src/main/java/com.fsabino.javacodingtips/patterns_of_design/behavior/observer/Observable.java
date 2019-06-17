package com.fsabino.javacodingtips.patterns_of_design.behavior.observer;

import java.util.HashSet;
import java.util.Set;

public class Observable {
	private Set<Observer> listObserver = new HashSet<Observer>();
	
	public void addObserver(Observer o) {
		this.listObserver.add(o);
	}
	
	public void removeObserver(Observer o) {
		this.listObserver.remove(o);
	}
	
	public void executeObservers () {
		for (Observer observer : listObserver) {
			observer.update();
		}
	}
}
