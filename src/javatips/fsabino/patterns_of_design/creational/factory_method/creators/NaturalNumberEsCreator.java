package javatips.fsabino.patterns_of_design.creational.factory_method.creators;

import javatips.fsabino.patterns_of_design.creational.factory_method.idiomas.NaturalNumber;
import javatips.fsabino.patterns_of_design.creational.factory_method.idiomas.NaturalNumberEs;

public class NaturalNumberEsCreator extends NaturalNumberCreator {

	@Override
	public NaturalNumber createNaturalNumber() {
		return new NaturalNumberEs();
	}
}
