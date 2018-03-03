package javatips.fsabino.abstract_method_class;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListinProfesores {
	
	private List<Profesor> listinProfesores;
	
	public ListinProfesores() {
		listinProfesores = new ArrayList<Profesor>();
	}
	public void addProfesor(Profesor profesor) {
		listinProfesores.add(profesor);
	}

	public void imprimirListin() {

		String tmpStr1 = ""; 
		System.out.println("Se procede a mostrar los datos de los profesores existentes en el listín \n");

		for (Profesor profesor : listinProfesores) {
			
			System.out.println(profesor.toString());
			
			if (profesor instanceof ProfesorInterino) {
				tmpStr1 = "Interino";
			} else {
				tmpStr1 = "Titular";
			}
			System.out.println(
					"-Tipo de este profesor:" + tmpStr1 + " -Nómina de este profesor: " + (profesor.importeNomina()) + "\n");
		}
	} 

	public float importeTotalNominaProfesorado() {
		float importeTotal = 0f;
		Iterator<Profesor> it = listinProfesores.iterator();

		while (it.hasNext()) {
			importeTotal = importeTotal + it.next().importeNomina();
		}
		return importeTotal;
	} 
}
