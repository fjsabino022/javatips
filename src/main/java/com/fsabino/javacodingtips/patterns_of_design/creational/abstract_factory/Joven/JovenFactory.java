package com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.Joven;

import com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.Cuenta;
import com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.CuentasFactory;
import com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.TarjetaCredito;
import com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory.TarjetaDebito;

public class JovenFactory extends CuentasFactory {

	// interfaces
	private Cuenta cuentaJoven;
	private TarjetaCredito tarjetaCreditoJoven;
	private TarjetaDebito tarjetaDebitoJoven;
	
	@Override
	public Cuenta getCuenta() {
		if (cuentaJoven == null) {
			return new CuentaJoven();
		}
		return cuentaJoven;
	}

	@Override
	public TarjetaCredito getTarjetaCredito() {
		if (tarjetaCreditoJoven == null) {
			return new TarjetaCreditoJoven();
		}
		return tarjetaCreditoJoven;
	}

	@Override
	public TarjetaDebito getTarjetaDebito() {
		if (tarjetaDebitoJoven == null) {
			return new TarjetaDebitoJoven();
		}
		return tarjetaDebitoJoven;
	}

}
