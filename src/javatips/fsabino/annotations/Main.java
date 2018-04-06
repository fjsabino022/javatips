package javatips.fsabino.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javatips.fsabino.annotations.annotation.FrutoSeco;

public class Main {

	public static void main(String[] args) {
		
		BolsitaMarcaA bolsitaMarcaA = new BolsitaMarcaA();
		
		// here will analice the annotations
		int caloriasTotalesA = contarCaloriasTotalesFrutosSecos(bolsitaMarcaA);
		System.out.println("Calorias totales de los frutos secos de una bolsita de la marca 'A': " + caloriasTotalesA);
	}

	public static int contarCaloriasTotalesFrutosSecos(final Object bolsita) {
		
		Class<?> claseBolsita = bolsita.getClass();

		int caloriasTotales = 0;

		// obtain the variables by reflection
		final Field[] variables = claseBolsita.getDeclaredFields();
		
		for (final Field variable : variables) {

			// for each variable we ask if It has a annotation
			final Annotation anotacionObtenida = variable.getAnnotation(FrutoSeco.class);

			if (anotacionObtenida != null && anotacionObtenida instanceof FrutoSeco) {
				
				final FrutoSeco anotacionFrutoSeco = (FrutoSeco) anotacionObtenida;

				int calorias = anotacionFrutoSeco.calorias();

				int cantidad = 0;
				try {
					
					// we ask if we can access to value
					variable.setAccessible(true);
					
					// we ask value of the variable
					cantidad = variable.getInt(bolsita);
					
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}

				String nombreFrutoSeco = variable.getName();

				System.out.println("	-Hay " + cantidad + " de " + nombreFrutoSeco + ", y cada una tiene " + calorias + " calorías");

				caloriasTotales += (cantidad * calorias);
			}
		}

		return caloriasTotales;
	}
}
