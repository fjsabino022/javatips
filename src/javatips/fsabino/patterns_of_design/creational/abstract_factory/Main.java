package javatips.fsabino.patterns_of_design.creational.abstract_factory;

import javatips.fsabino.patterns_of_design.creational.abstract_factory.Joven.JovenFactory;
import javatips.fsabino.patterns_of_design.creational.abstract_factory.Oro.OroFactory;
import javatips.fsabino.patterns_of_design.creational.abstract_factory.Tipo10.Tipo10Factory;

public class Main {

	public static void main(String[] args) {
		
		CuentasFactory factoryConcrete;
		
		// realizamos la inyeccion de dependencias
		factoryConcrete =  new OroFactory();
		CuentasFactory.setCuentasFactory(factoryConcrete);
		
		System.out.println("-----------------------------------------");
		System.out.println(factoryConcrete.getCuenta().show());
		System.out.println(factoryConcrete.getTarjetaCredito().show());
		System.out.println(factoryConcrete.getTarjetaDebito().show());
		
		System.out.println("-----------------------------------------");
		factoryConcrete =  new JovenFactory();
		CuentasFactory.setCuentasFactory(factoryConcrete);
		
		System.out.println(factoryConcrete.getCuenta().show());
		System.out.println(factoryConcrete.getTarjetaCredito().show());
		System.out.println(factoryConcrete.getTarjetaDebito().show());
		
		System.out.println("-----------------------------------------");
		factoryConcrete =  new Tipo10Factory();
		CuentasFactory.setCuentasFactory(factoryConcrete);
		
		System.out.println(factoryConcrete.getCuenta().show());
		System.out.println(factoryConcrete.getTarjetaCredito().show());
		System.out.println(factoryConcrete.getTarjetaDebito().show());
		System.out.println("-----------------------------------------");
	}

}
