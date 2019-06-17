package com.fsabino.javacodingtips.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		List<Persona> milista= new ArrayList<Persona>();
		milista.add(new Persona("Miguel"));
		milista.add(new Persona("Alicia"));
		milista.add(new Persona("Franco"));
		
		Collections.sort(milista,new Comparator<Persona>() {
			 public int compare(Persona p1,Persona p2) {
				return p1.getNombre().compareTo(p2.getNombre());
			}
		});
		 
		for (Persona p: milista) { 
			System.out.println("Sin lambda: "+ p.getNombre()); 
		}
		
		List<Persona> milista2= new ArrayList<Persona>();
		milista2.add(new Persona("Miranda"));
		milista2.add(new Persona("Fabiola"));
		milista2.add(new Persona("Arandanos"));
		
		Collections.sort(milista2, (Persona p1, Persona p2) -> p1.getNombre().compareTo(p2.getNombre()) );
		 
		for (Persona p: milista2) { 
			System.out.println("Con lambda: "+ p.getNombre());
		 
		}
	}
}
