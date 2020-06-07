package com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.Oro;

import com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.TarjetaDebito;

public class TarjetaDebitoOro implements TarjetaDebito {

	@Override
	public String show() {
		return "Tarjeta debito de oro y son 10 euros y como maximo 2000 euros";
	}
}
