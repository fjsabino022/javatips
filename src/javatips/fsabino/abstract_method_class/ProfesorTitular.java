package javatips.fsabino.abstract_method_class;

public class ProfesorTitular extends Profesor {

	public ProfesorTitular(String nombre, String apellidos, int edad, String id) {
		super(nombre, apellidos, edad, id);
	}

	/**
	 * Si la clase es cocreta y a la vez hereda de una clase abstracta, debe
	 * implementar todos los metodos abstractos declarados en la superclase
	 * abstracta.
	 */
	@Override
	public float importeNomina() {
		return 30f * 43.20f; 
	}
}
