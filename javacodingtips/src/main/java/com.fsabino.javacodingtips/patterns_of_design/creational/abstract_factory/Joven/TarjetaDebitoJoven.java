package com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.Joven;

import com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.TarjetaDebito;

public class TarjetaDebitoJoven implements TarjetaDebito {

	@Override
	public String show() {
		return "Soy la tarjeta debito de Joven y la comision es de gratuita";
	}
}
