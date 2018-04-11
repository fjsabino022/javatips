package javatips.fsabino.patterns_of_design.creational.abstract_factory.Joven;

import javatips.fsabino.patterns_of_design.creational.abstract_factory.TarjetaCredito;

public class TarjetaCreditoJoven implements TarjetaCredito {

	@Override
	public String show() {
		// TODO Auto-generated method stub
		return "Soy la tarjeta credito de Joven y la comision es de gratuita max 600";
	}
}
