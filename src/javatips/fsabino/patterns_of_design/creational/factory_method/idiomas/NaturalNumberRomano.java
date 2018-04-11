package javatips.fsabino.patterns_of_design.creational.factory_method.idiomas;

public class NaturalNumberRomano extends NaturalNumber {
	private static final String[] arreglo = {"I", "II", "III", "IV", "V"};
	@Override
	public String getTextByNumber(int indice) {
		return arreglo[indice];
	}
}
