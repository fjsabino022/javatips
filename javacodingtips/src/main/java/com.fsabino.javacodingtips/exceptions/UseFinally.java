package com.fsabino.javacodingtips.exceptions;

/**
 * El bloque finally será ejecutado cada vez que se termine un bloque try/catch,
 * sin importar como se salga del bloque try.
 */
public class UseFinally {
	public static void generaExcepcion(int i) {
		int t;
		int num[] = { 2, 4, 6 };
		System.out.println("Recibiendo " + i);
		try {
			switch (i) {
			case 0:
				t = 10 / i; // division por cero
				break;
			case 1:
				num[4] = 4; // genera un error
				break;
			case 2:
				return;
			}
		} catch (ArithmeticException exc) {
			System.out.println("No puede dividir entre cero");
			return;
		} catch (ArrayIndexOutOfBoundsException exc) {
			System.out.println(" No hay elementos que coincidan");
		} finally {
			System.out.println("Ejecutando codigo de limpieza");
		}
	} // fin de metodo
}
