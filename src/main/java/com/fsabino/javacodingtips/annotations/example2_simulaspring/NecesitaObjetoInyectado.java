package com.fsabino.javacodingtips.annotations.example2_simulaspring;

import com.fsabino.javacodingtips.annotations.annotation.Autowired;

public class NecesitaObjetoInyectado {
	
	@Autowired
	private Inyectar miObjetoInyectado;

	public void usarObjetoInyectadoYMostrarPorPantalla() {		
		String textoObtenidoDeObjetoInyectado = miObjetoInyectado.metodoDeObjetoInyectado();		
		System.out.println("Lo que me devuelve el método del objeto que me han inyectado: " + textoObtenidoDeObjetoInyectado);
	}
}
