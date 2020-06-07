package com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.Tipo10;

import com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.TarjetaDebito;

public class TarjetaDebitoTipo10 implements TarjetaDebito{

	@Override
	public String show() {
		return "Tarjeta de debito tipo 10 es gratuita";
	}
}
