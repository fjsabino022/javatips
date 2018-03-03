package javatips.fsabino.abstract_method_class;

import java.util.Calendar;

public class ProfesorInterino extends Profesor {

	private Calendar fechaComienzoInterinidad;

	public ProfesorInterino(Calendar fechaInicioInterinidad) {
		super();
		fechaComienzoInterinidad = fechaInicioInterinidad;
	}

	public ProfesorInterino(String nombre, String apellidos, int edad, String id, Calendar fechaInicioInterinidad) {
		super(nombre, apellidos, edad, id);
		fechaComienzoInterinidad = fechaInicioInterinidad;
	}

	public Calendar getFechaComienzoInterinidad() {
		return fechaComienzoInterinidad;
	}

	// Sobre escribimos un metodo que no es abstracto de la superclase abstracta
	public String toString() { 
		return super.toString().concat(" Fecha comienzo interinidad: ")
				.concat(fechaComienzoInterinidad.getTime().toString());
	}

	@Override
	public float importeNomina() {
		// TODO Auto-generated method stub
		return 30f * 35.60f ; 
	}
}
