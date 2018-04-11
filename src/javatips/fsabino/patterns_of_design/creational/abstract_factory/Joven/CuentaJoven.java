package javatips.fsabino.patterns_of_design.creational.abstract_factory.Joven;

import javatips.fsabino.patterns_of_design.creational.abstract_factory.Cuenta;

public class CuentaJoven implements Cuenta {

	@Override
	public String show() {
		return "Soy la cuenta de Joven y la comision es de 1%";
	}

}
