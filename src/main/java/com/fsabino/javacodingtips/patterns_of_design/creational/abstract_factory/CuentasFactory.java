package com.fsabino.javacodingtips.patterns_of_design.creational.abstract_factory;

public abstract class CuentasFactory {
	private static CuentasFactory cuenta;
	
	public static void setCuentasFactory(CuentasFactory c) {
		cuenta = c;
	}
	
	public static CuentasFactory getCuentasFactory() {
		return cuenta;
	}
	
	public abstract Cuenta getCuenta();
	public abstract TarjetaCredito getTarjetaCredito();
	public abstract TarjetaDebito getTarjetaDebito();
}
