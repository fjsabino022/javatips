package javatips.fsabino.annotations.example2_simulaspring;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javatips.fsabino.annotations.annotation.Autowired;

public class SimulaSpring {

	public static void main(String[] args) {
		
		NecesitaObjetoInyectado necesitaInyeccion = new NecesitaObjetoInyectado();
		
		//Srping facilita un poco más al instanciar los objetos y no necesitar pedir la inyección a un objeto propiamente
		//por simplificar pediremos la inyección directamente
		inyectorDeObjetos(necesitaInyeccion);
		
		necesitaInyeccion.usarObjetoInyectadoYMostrarPorPantalla();
	}

	/**
	 * Inyecta un objeto cualquiera que esté anotado con @Autowired (Este método simula al Framework Spring)
	 * 
	 * @param objetoNecesitaInyeccion objeto que requiere ser inyectado
	 */
	public static void inyectorDeObjetos (final Object objetoNecesitaInyeccion) {
		Class<?> claseObjetoNecesitaInyeccion = objetoNecesitaInyeccion.getClass();

		final Field[] variables = claseObjetoNecesitaInyeccion.getDeclaredFields();
		for (final Field variable : variables) {
			
			final Annotation anotacionObtenida = variable.getAnnotation(Autowired.class);

			if (anotacionObtenida != null && anotacionObtenida instanceof Autowired) {	
				//Obtiene el tipo de clase a inyectar, independientemente del tipo	
				Class<?> claseInyectar = variable.getType(); 
				
				try {
					//Instanciamos el objeto a inyectar
					Object nuevoObjetoDeMiClase = claseInyectar.getConstructor().newInstance(); 
					
					variable.setAccessible(true);

					//Inyectamos el objeto en la variable del objeto que requiere la inyección
					variable.set(objetoNecesitaInyeccion, nuevoObjetoDeMiClase);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
}
