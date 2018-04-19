package javatips.fsabino.patterns_of_design.creational.prototype.problem;

import java.util.ArrayList;
import java.util.List;

import javatips.fsabino.patterns_of_design.creational.prototype.Record;

public class PrototypeEveryDayMain {

	public static void main(String[] args) {
		
		String sql = "select * from movies where title = ?";

		List<String> parameters = new ArrayList<>();

		parameters.add("Star wars");

		Record record = new Record();

		Statement firstStatement = new Statement(sql, parameters, record);

		System.out.println(firstStatement.getSql());

		System.out.println(firstStatement.getParameters());

		System.out.println(firstStatement.getRecord());

		Statement secondStatement = firstStatement.clone();

		System.out.println(secondStatement.getSql());

		System.out.println(secondStatement.getParameters());

		// Podemos ver que se realiza una copia SUPERFICIAL
		// la clonacion te termina otorgando el mismo objeto de Record y no nos sirve
		// ya que queremos que se clone y nos devuelva una nueva instancia del objeto. (Clonacion profunda)
		System.out.println(secondStatement.getRecord());
	}
}
