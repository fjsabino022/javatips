package javatips.fsabino.patterns_of_design.creational.abstract_factory.Tipo10;

import javatips.fsabino.patterns_of_design.creational.abstract_factory.Cuenta;

public class CuentaTipo10 implements Cuenta {

	@Override
	public String show() {
		return "Cuenta de tipo 10. comision 1,5%";
	}
}
