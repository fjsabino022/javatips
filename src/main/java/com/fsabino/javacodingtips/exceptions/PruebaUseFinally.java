package com.fsabino.javacodingtips.exceptions;

public class PruebaUseFinally {

	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			UseFinally.generaExcepcion(i);
			System.out.println();
		}
	}
}
