package com.fsabino.javacodingtips.patterns_of_design.behavior.estrategy;

import com.fsabino.javacodingtips.patterns_of_design.behavior.estrategy.algoritmos.EnAire;
import com.fsabino.javacodingtips.patterns_of_design.behavior.estrategy.algoritmos.EnAireVeloz;
import com.fsabino.javacodingtips.patterns_of_design.behavior.estrategy.algoritmos.EnTierra;
import com.fsabino.javacodingtips.patterns_of_design.behavior.estrategy.aviones.Avion;
import com.fsabino.javacodingtips.patterns_of_design.behavior.estrategy.aviones.AvionComercial;
import com.fsabino.javacodingtips.patterns_of_design.behavior.estrategy.aviones.AvionGuerra;

public class Main {

	public static void main(String[] args) {
		Avion acomercial = new AvionComercial();
		Avion aguerra = new AvionGuerra();
	
		// fist, acomercial start trip, fly slowly and after that fly fast
		acomercial.setAlgoritmo(new EnTierra());
		acomercial.mover();
		acomercial.setAlgoritmo(new EnAire());
		acomercial.mover();
		acomercial.setAlgoritmo(new EnAireVeloz());
		acomercial.mover();
		
		System.out.println();
		
		// fist, acomercial start trip and fly fast
		aguerra.setAlgoritmo(new EnTierra());
		aguerra.mover();
		aguerra.setAlgoritmo(new EnAireVeloz());
		aguerra.mover();
	}
}
