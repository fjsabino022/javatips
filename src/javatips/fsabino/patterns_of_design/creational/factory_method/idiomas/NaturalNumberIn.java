package javatips.fsabino.patterns_of_design.creational.factory_method.idiomas;

public class NaturalNumberIn extends NaturalNumber {

	private static final String[] arreglo = {"one", "two", "three", "four", "five"};
	@Override
	public String getTextByNumber(int indice) {
		return arreglo[indice];
	}
}
