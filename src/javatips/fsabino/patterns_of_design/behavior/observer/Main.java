package javatips.fsabino.patterns_of_design.behavior.observer;

import javatips.fsabino.patterns_of_design.behavior.observer.observers.ObserverA;
import javatips.fsabino.patterns_of_design.behavior.observer.observers.ObserverB;
import javatips.fsabino.patterns_of_design.behavior.observer.observers.ObserverC;

public class Main {

	public static void main(String[] args) {
		
		// create Subject
		Subject s = new Subject();
		
		// create three observer with a parameter subject0
		new ObserverA(s);
		new ObserverB(s);
		new ObserverC(s);
		
		// show state of subject
		System.out.println("Estado Inicial: "+ s.getState());
		
		// change state of subject, must execute update method in all Observers
		s.setState(22);
	}
}
