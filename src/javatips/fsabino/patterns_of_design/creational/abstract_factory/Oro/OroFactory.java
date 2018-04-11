package javatips.fsabino.patterns_of_design.creational.abstract_factory.Oro;

import javatips.fsabino.patterns_of_design.creational.abstract_factory.Cuenta;
import javatips.fsabino.patterns_of_design.creational.abstract_factory.CuentasFactory;
import javatips.fsabino.patterns_of_design.creational.abstract_factory.TarjetaCredito;
import javatips.fsabino.patterns_of_design.creational.abstract_factory.TarjetaDebito;

public class OroFactory extends CuentasFactory {

	private Cuenta cuenta;
	private TarjetaCredito tarjetaCredito;
	private TarjetaDebito tarjetaDebito;
	
	@Override
	public Cuenta getCuenta() {
		if (cuenta == null) {
			return new CuentaOro();
		}
		return cuenta;
	}

	@Override
	public TarjetaCredito getTarjetaCredito() {
		if (tarjetaCredito == null) {
			return new TarjetaCreditoOro();
		}
		return tarjetaCredito;
	}

	@Override
	public TarjetaDebito getTarjetaDebito() {
		if (tarjetaDebito == null) {
			return new TarjetaDebitoOro();
		}
		return tarjetaDebito;
	}
}
