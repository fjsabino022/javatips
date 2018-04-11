package javatips.fsabino.patterns_of_design.creational.factory_method.idiomas;

public class NaturalNumberEs extends NaturalNumber {

	private static final String[] arreglo = {"uno", "dos", "tres", "cuatro", "cinco"};
	@Override
	public String getTextByNumber(int indice) {
		return arreglo[indice];
	}
}
