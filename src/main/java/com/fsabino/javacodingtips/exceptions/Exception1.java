package com.fsabino.javacodingtips.exceptions;

/**
 * Las excepciones que derivan de Error o RuntimeException no necesitan ser
 * especificados en una lista throws. Todos los otros tipos de excepciones
 * necesitan ser declarados, o se producen errores en tiempo de compilación. Por
 * ejemplo, en la entrada por teclado se puede generar una excepcion
 * IOException, la cual no puede manejarse en el programa.*
 * Bibliografia: http://fcqi.tij.uabc.mx/usuarios/palacios/java5.pdf
 */
public class Exception1 {

	/**
	 * genera un error en tiempo de ejecucion es una exception hererada de la clase
	 * Exception porque intenta acceder a un indice de array incorrecto
	 */
	public static void main(String[] args) {
		int numero[] = new int[5];
		numero[7] = 0;
	}

	public static void mainPaso2(String[] args) {
		int numero[] = new int[5];
		try {
			numero[7] = 0;
		} catch (java.lang.ArrayIndexOutOfBoundsException Error) {
			System.out.println("Se genero una excepcion al acceder al arreglo");
		}
	}
}
