package javatips.fsabino.patterns_of_design.behavior.estrategy.aviones;

import javatips.fsabino.patterns_of_design.behavior.estrategy.algoritmos.Algoritmo;

public abstract class Avion {
	private Algoritmo algoritmo;
	
	public void setAlgoritmo (Algoritmo a) {
		algoritmo = a;
	}
	
	public void mover() {
		this.algoritmo.mover();
	}
}
