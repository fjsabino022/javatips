package com.fsabino.javacodingtips.patterns_of_design.creational.factory_method.creators;

import com.fsabino.javacodingtips.patterns_of_design.creational.factory_method.idiomas.NaturalNumber;
import com.fsabino.javacodingtips.patterns_of_design.creational.factory_method.idiomas.NaturalNumberEs;

public class NaturalNumberEsCreator extends NaturalNumberCreator {

	@Override
	public NaturalNumber createNaturalNumber() {
		return new NaturalNumberEs();
	}
}
