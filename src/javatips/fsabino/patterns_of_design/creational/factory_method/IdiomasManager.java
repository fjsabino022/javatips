package javatips.fsabino.patterns_of_design.creational.factory_method;

import javatips.fsabino.patterns_of_design.creational.factory_method.creators.NaturalNumberCreator;
import javatips.fsabino.patterns_of_design.creational.factory_method.idiomas.NaturalNumber;

public class IdiomasManager {
	
	// clase abstracta de numeros
	private NaturalNumber naturalNumber;
	
	// clase abtracta creadora
	private NaturalNumberCreator naturalNumberCreator;

	public void setCreator (NaturalNumberCreator nnc) {
		this.naturalNumberCreator = nnc;
	}
	
	public void createIdioma () {
		this.naturalNumber = this.naturalNumberCreator.createNaturalNumber();
	}
	
	public NaturalNumber getNaturalNumber () {
		return naturalNumber;
	}
}
