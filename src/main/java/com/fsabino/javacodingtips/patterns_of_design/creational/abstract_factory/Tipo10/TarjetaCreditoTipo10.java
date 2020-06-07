package com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.Tipo10;

import com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.TarjetaCredito;

public class TarjetaCreditoTipo10 implements TarjetaCredito {

	@Override
	public String show() {
		return "Tarjeta de credito tipo 10 es gratuita pero max 2000";
	}
}
