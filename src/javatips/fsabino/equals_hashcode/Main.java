package javatips.fsabino.equals_hashcode;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		// creating the Objects of Geek class.
		Geek g1 = new Geek("aa", 1);
		Geek g2 = new Geek("aa", 1);

		// comparing above created Objects.
		if (g1.hashCode() == g2.hashCode()) {
			if (g1.equals(g2))
				System.out.println("Both Objects are equal. ");
			else
				System.out.println("Both Objects are not equal. ");
		} else
			System.out.println("Both Objects are not equal. ");

		Categoria categoria1 = new Categoria("1", "codigo1");
		Categoria categoria2 = new Categoria("1", "codigo2");

		//equals va a ser igual
		if (categoria1.equals(categoria2)) {
			System.out.println("Both Objects are equal. ");
		}

		//hascode va a ser igual
		if (categoria1.hashCode() == categoria2.hashCode()) {
			System.out.println("HashCode are equal.. ");
		}

		// how to work hascode and equals in hash structures
		Map<Integer, Categoria> map = new HashMap<Integer, Categoria>();
		map.put(1, categoria1);
		map.put(2, categoria2);
		map.get(1);
	}
}
