package javatips.fsabino.patterns_of_design.creational.abstract_factory.Oro;

import javatips.fsabino.patterns_of_design.creational.abstract_factory.Cuenta;

public class CuentaOro implements Cuenta {

	@Override
	public String show() {
		return "Es la cuenta de Oro y es 2%";
	}
}
