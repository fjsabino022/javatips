package com.fsabino.javacodingtips.patterns_of_design.creational.factory_method;

import com.fsabino.javacodingtips.patterns_of_design.creational.factory_method.creators.NaturalNumberCreator;
import com.fsabino.javacodingtips.patterns_of_design.creational.factory_method.creators.NaturalNumberEsCreator;
import com.fsabino.javacodingtips.patterns_of_design.creational.factory_method.creators.NaturalNumberInCreator;
import com.fsabino.javacodingtips.patterns_of_design.creational.factory_method.creators.NaturalNumberRomanoCreator;

public class Main {

	public static void main(String[] args) {
		
		// clase abstracta de creador numeros naturales 
		NaturalNumberCreator naturalNumberCreator;
		IdiomasManager imanager =  new IdiomasManager();
		
		// seteamos el creador que queremos
		naturalNumberCreator = new NaturalNumberEsCreator();
		imanager.setCreator(naturalNumberCreator);
		imanager.createIdioma();
		
		for (int i = 0; i < 5 ; i++) {
			System.out.println(imanager.getNaturalNumber().getTextByNumber(i));
		}
		
		naturalNumberCreator = new NaturalNumberInCreator();
		imanager.setCreator(naturalNumberCreator);
		imanager.createIdioma();
		
		for (int i = 0; i < 5 ; i++) {
			System.out.println(imanager.getNaturalNumber().getTextByNumber(i));
		}
		
		naturalNumberCreator = new NaturalNumberRomanoCreator();
		imanager.setCreator(naturalNumberCreator);
		imanager.createIdioma();
		for (int i = 0; i < 5 ; i++) {
			System.out.println(imanager.getNaturalNumber().getTextByNumber(i));
		}
	}

}
