package com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.Tipo10;

import com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.Cuenta;
import com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.CuentasFactory;
import com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.TarjetaCredito;
import com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.TarjetaDebito;

public class Tipo10Factory extends CuentasFactory {

	// interfaces
	private Cuenta cuenta;
	private TarjetaCredito tarjetaCredito;
	private TarjetaDebito tarjetaDebito;
		
	@Override
	public Cuenta getCuenta() {
		if (cuenta == null) {
			return new CuentaTipo10();
		}
		return cuenta;
	}

	@Override
	public TarjetaCredito getTarjetaCredito() {
		if (tarjetaCredito == null) {
			return new TarjetaCreditoTipo10();
		}
		return tarjetaCredito;
	}

	@Override
	public TarjetaDebito getTarjetaDebito() {
		if (tarjetaDebito == null) {
			return new TarjetaDebitoTipo10();
		}
		return tarjetaDebito;
	}
}
