package javatips.fsabino.annotations.example2_simulaspring;

import javatips.fsabino.annotations.annotation.Autowired;

public class NecesitaObjetoInyectado {
	
	@Autowired
	private Inyectar miObjetoInyectado;

	public void usarObjetoInyectadoYMostrarPorPantalla() {		
		String textoObtenidoDeObjetoInyectado = miObjetoInyectado.metodoDeObjetoInyectado();		
		System.out.println("Lo que me devuelve el método del objeto que me han inyectado: " + textoObtenidoDeObjetoInyectado);
	}
}
