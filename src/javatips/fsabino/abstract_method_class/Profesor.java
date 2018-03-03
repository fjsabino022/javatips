package javatips.fsabino.abstract_method_class;

/**
 * Bibliografia: 
 * https://www.aprenderaprogramar.com/index.php?option=com_content&view=article&id=668:clases-y-metodos-abstractos-en-java-abstract-class-clases-del-api-ejemplos-codigo-y-ejercicios-cu00695b&catid=68&Itemid=188
 * */
public abstract class Profesor extends Persona {
	
	private String IdProfesor;

	public Profesor() {
		super();
		IdProfesor = "Unknown";
	}

	public Profesor(String nombre, String apellidos, int edad, String id) {
		super(nombre, apellidos, edad);
		IdProfesor = id;
	}

	public void setIdProfesor(String IdProfesor) {
		this.IdProfesor = IdProfesor;
	}

	public String getIdProfesor() {
		return IdProfesor;
	}
	
	/**	una clase abstracta puede contener metodos no abstractos
		es un metodo concreto porque tiene implementacion
	*/
	public void mostrarDatos() {

		System.out.println("Datos Profesor. Profesor de nombre: " + getNombre() + " " +

				getApellidos() + " con Id de profesor: " + getIdProfesor());
	}

	// una clase abstracta puede contener metodos no abstractos
	public String toString() {
		return super.toString().concat(" -IdProfesor: ").concat(IdProfesor);
	}

	/**
	 * 	Si existe al menos un metodo que sea abstracto, la clase debe ser abstracta
		Metodo abstracto:
			a) No tiene cuerpo (llaves): sólo consta de signatura con paréntesis.
			b) Su signatura termina con un punto y coma.
			c) Sólo puede existir dentro de una clase abstracta. 
				De esta forma se evita que haya métodos que no se puedan ejecutar dentro de clases concretas. 
				Visto de otra manera, si una clase incluye un método abstracto, 
				forzosamente la clase será una clase abstracta.
			d) Los métodos abstractos forzosamente habrán de estar sobreescritos en las subclases. 
			Si una subclase no implementa un método abstracto de la superclase tiene un método no ejecutable, 
			lo que la fuerza a ser una subclase abstracta. 
			Para que la subclase sea concreta habrá de implementar métodos sobreescritos 
			para todos los métodos abstractos de sus superclases.
	*/
	abstract public float importeNomina();
}
