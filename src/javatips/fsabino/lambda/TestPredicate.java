package javatips.fsabino.lambda;

public class TestPredicate {

	public static void main(String[] args) {

		Predicate<String> predicate = s -> s.length() > 10;

		boolean v1 = predicate.test("Franco");
		System.out.println("Valor de variable 1: " + v1);

		boolean v2 = predicate.test("Franco tiene que tener una longitud mayor de 20");
		System.out.println("Valor de variable 2: " + v2);

		Predicate<String> predicate2 = s -> s.length() < 50;

		// IMPLEMENTAMOS UN NUEVO METODO EN LA INTERFAZ FUNCIONAL -> AND
		Predicate<String> predicate3 = predicate.and(predicate2);

		System.out.println("predicate 3 for FRANCO SABINO " + predicate3.test("FRANCO SABINO"));
		System.out.println("predicate 3 for OTRA FRASE "
				+ predicate3.test("FRANCO SABINO GARELLA NACIO EN TOTORAS EN 1990 Y ESTO ERA UNA ALDEA DE TIERRA"));

		// METODO STATICO EN INTERFAZ FUNCIONAL
		Predicate<String> p4 = Predicate.isEqualsTo("Hola");
		System.out.println("Probando metodo statico " + p4.test("Hola"));
		System.out.println("Probando metodo statico " + p4.test("HolA"));

		// METODO STATICO GENERICO EN INTERFAZ FUNCIONAL
		Predicate<Integer> p5 = Predicate.isEqualsToGen(1);
		System.out.println("Probando metodo statico generico " + p5.test(1));
		System.out.println("Probando metodo statico generico " + p5.test(0));
	}

}
