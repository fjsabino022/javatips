package javatips.fsabino.patterns_of_design.creational.singleton.pluralsight;

public class DbSingleton {

	/**
	 * 
	 * Volatile Variable
	 * 
	 * La palabra clave volatile, hace referencia a concurrencia. Esta palabra clave
	 * es util cuando existen muchos hilos tratando de leer el valor de una
	 * variable. Cuando una variable es marcada como volatile, el valor de esa
	 * variable es escrita y es leída desde la memoria principal. Para entender un
	 * poco el concepto es necesario tener claro algunas cosas.
	 * 
	 * Cuando se trabaja con hilos, usualmente cada hilo hace una copia de la
	 * variable a leer en su cache, cada hilo tiene una memoria cache que usa por
	 * performance, es mas rápido y menos costoso. Pero el tener esto local, cuando
	 * muchos hilos trabajan sobre la misma variable, suelen ocurrir errores en
	 * cuanto a consistencia de la información.
	 * 
	 * Pero cuando una variable es marcada como volatile, el hilo no hace una copia
	 * en su memoria cache, sino que lee y escribe directamente en la memoria
	 * principal.
	 * 
	 * Esto garantiza que el valor que se lee es siempre el mas actualizado. Por
	 * tanto no hay un lock o bloqueo al leer o escribir el valor de dicha variable.
	 * Cuando se lee una variable que esta marcada como volatile no es necesario
	 * usar synchronized ya que volatile garantiza que se la variable tiene el valor
	 * actualizado, el ultimo siempre. Pero si es recomendable usarlo cuando varios
	 * hilos leen y escriben.
	 * 
	 * Cabe resaltar que el escribir y leer de la memoria principal es mas costoso
	 * por tanto impacta en el performance de la aplicación, hay que saber cuando y
	 * donde usar volatile.
	 * 
	 * La forma de declarar una variable es la siguiente:
	 * 
	 * public volatile int counter = 0;
	 * 
	 * NOTA: Las keyword o palabras clave transient y volatile solo se aplican a
	 * variables de instancia. NO se puede aplicar a métodos, clases o variables
	 * locales (dentro de un método).
	 * 
	 ***************************************************************************
	 *
	 * La palabra reservada synchronized 
	 * 
	 * La palabra reservada synchronized se usa
	 * para indicar que ciertas partes del código, (habitualmente, una función
	 * miembro) están sincronizadas, es decir, que solamente un subproceso puede
	 * acceder a dicho método a la vez.
	 * 
	 * Cada método sincronizado posee una especie de llave que puede cerrar o abrir
	 * la puerta de acceso. Cuando un subproceso intenta acceder al método
	 * sincronizado mirará a ver si la llave está echada, en cuyo caso no podrá
	 * accederlo. Si método no tiene puesta la llave entonces el subproceso puede
	 * acceder a dicho código sincronizado.
	 * 
	 * Las siguientes porciones de código son ejemplos de uso del modificador
	 * synchronized
	 * 
	 * synchronized public void funcion1(){ 
	 * 		//... 
	 * } 
	 * 
	 * public void funcion2(){
	 * 		Rectangle rect; 
	 * 		synchronized(rect) { 
	 * 				rect.width+=2; 
	 *		} 
	 *		rect.height-=3;
	 *} 
	 * 
	 * Un ejemplo que veremos más adelante es la sincronización de una porción de
	 * código usando el objeto this, en el interior de una función miembro
	 * denominada mover
	 * 
	 * public void mover(){ 
	 * 	synchronized (this) { 
	 * 		indice++; 
	 * 		if (indice>= numeros.length) { 
	 * 			indice=0; 
	 * 		} 
	 * 	  } //... 
	 *	} 
	 *
	 * En la primera porción de código, hemos asegurado un método de modo que un sólo subproceso a la vez puede
	 * acceder a la funcion1. En la segunda y tercera porción de código, tenemos un
	 * bloque de código asegurado. La anchura width del rectángulo rect no puede ser
	 * modificada por varios subprocesos a la vez. La altura height del rectángulo
	 * no está dentro del bloque sincronizado y puede ser modificada por varios
	 * subprocesos a la vez. El objeto rect se usa en este caso como llave de dicho
	 * bloque de código, en el tercer ejemplo este papel lo representa this.
	 * 
	 * Se debe evitar la sincronización de bloques de código y sustituirlas siempre
	 * que sea posible por la sincronización de métodos, lo que está más de acuerdo
	 * con el espíritu de la programación orientada a objetos. Se debe tener en
	 * cuenta que la sincronización disminuye el rendimiento de una aplicación, por
	 * tanto, debe emplearse solamente donde sea estrictamente necesario.
	 */
	private static volatile DbSingleton instance = new DbSingleton(); // faster load

	// private constructor
	private DbSingleton() {
		if (instance != null) {
			throw new RuntimeException("Use getInstance() method to create");
		}
	}

	// public method and static
	public static DbSingleton getInstance() {
		if (instance == null) {
			synchronized (DbSingleton.class) {
				if (instance == null) {
					instance = new DbSingleton();
				}
			}
		}
		return instance;
	}
}
