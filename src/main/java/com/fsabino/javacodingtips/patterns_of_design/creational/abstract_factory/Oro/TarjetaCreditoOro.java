package com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.Oro;

import com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.TarjetaCredito;

public class TarjetaCreditoOro implements TarjetaCredito {

	@Override
	public String show() {
		return "Tarjeta Credito de oro y es gratuita entre 20 y 600 euros";
	}
}
