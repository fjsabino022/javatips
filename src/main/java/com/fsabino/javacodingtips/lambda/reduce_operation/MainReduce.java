package com.fsabino.javacodingtips.lambda.reduce_operation;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class MainReduce {

	public static void main(String[] args) {
		
		List<Integer> ints = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
		List<Integer> ints1 = Arrays.asList(0,1,2,3,4);
		List<Integer> ints2 = Arrays.asList(5,6,7,8,9);
		List<Integer> intsfornegartive = Arrays.asList(0,1,2,3,4,-1,-2,-3,-4);
		List<Integer> ints1fornegartive = Arrays.asList(0,1,2,3,4);
		List<Integer> ints2fornegartive = Arrays.asList(-1,-2,-3,-4);
		
		// Define a binary operator with lambda expression
		BinaryOperator<Integer> suma = Integer::sum;
		BinaryOperator<Integer> max = Integer::max;
		BinaryOperator<Integer> nonAsociativeOperation = (num1 , num2) -> (num1 + num2) * (num1 + num2);
		BinaryOperator<Integer> firstElementOperation = (num1 , num2) -> num1;
		BinaryOperator<Integer> averange = (num1 , num2) -> (num1 + num2)/2;
		
		// Add with reduce
		System.out.println("---------------CASO 1 CORRECTO-----------------");
		int reduction = reduce(ints, 0, suma);
		System.out.println("Suma de todos los elementos de la lista: "+ reduction);
	
		// Check the result when we use parallel reduce
		int reduction1 = reduce(ints1, 0, suma);
		int reduction2 = reduce(ints2, 0, suma);
		int reductionParallel = reduce(Arrays.asList(reduction1,reduction2), 0, suma);
		System.out.println("Suma de todos los elementos pero con reduccion paralela: "+ reductionParallel);
		System.out.println("Esto funciona correctamente en paralello porque la operacion num1 + num2 es ASOCIATIVA");
		
		System.out.println("---------------CASO 2 CORRECTO-----------------");
		int reductionMax = reduce(ints, 0, max);
		System.out.println("Maximo de todos los elementos de la lista: "+ reductionMax);
		
		int reduction1Max = reduce(ints1, 0, max);
		int reduction2Max = reduce(ints2, 0, max);
		int reductionMaxParallel = reduce(Arrays.asList(reduction1Max,reduction2Max), 0, max);
		System.out.println("Maximo de todos los elementos pero con reduccion paralela: "+ reductionMaxParallel);
		System.out.println("Esto funciona correctamente en paralello porque la operacion Integer.max(num1, num2) es ASOCIATIVA");
		
		System.out.println("---------------CASO 3 INCORRECTO-----------------");
		int reductionNonAssosiative = reduce(ints, 0, nonAsociativeOperation);
		System.out.println("Operacion de todos los elementos de la lista: "+ reductionNonAssosiative);
		
		int reduction1NonAssosiative = reduce(ints1, 0, nonAsociativeOperation);
		int reduction2NonAssosiative = reduce(ints2, 0, nonAsociativeOperation);
		int reductionNonAssosiativeParallel = reduce(Arrays.asList(reduction1NonAssosiative,reduction2NonAssosiative), 0, nonAsociativeOperation);
		System.out.println("Operacion de todoss los elementos pero con reduccion paralela: "+ reductionNonAssosiativeParallel);
		System.out.println("Esto NO funciona correctamente en paralello porque la operacion (num1 + num2) * (num1 + num2) NO es ASOCIATIVA");
		
		System.out.println("---------------CASO 4 CORRECTO-----------------");
		int reductionFirst = reduce(ints, 0, firstElementOperation);
		System.out.println("Primer elemento de todos los elementos de la lista: "+ reductionFirst);
		
		int reduction1First = reduce(ints1, 0, firstElementOperation);
		int reduction2First = reduce(ints2, 0, firstElementOperation);
		int reductionFirstParallel = reduce(Arrays.asList(reduction1First,reduction2First), 0, firstElementOperation);
		System.out.println("Primer elemento de todos los elementos pero con reduccion paralela: "+ reductionFirstParallel);
		System.out.println("Esto funciona correctamente en paralello porque la operacion num1 es ASOCIATIVA");
		
		System.out.println("---------------CASO 5 INCORRECTO-----------------");
		int reductionAverange = reduce(ints, 0, averange);
		System.out.println("Operacion de todos los elementos de la lista: "+ reductionAverange);
		
		int reduction1Averange = reduce(ints1, 0, averange);
		int reduction2Averange = reduce(ints2, 0, averange);
		int reductionAverangeParallel = reduce(Arrays.asList(reduction1Averange,reduction2Averange), 0, averange);
		System.out.println("Operacion de todoss los elementos pero con reduccion paralela: "+ reductionAverangeParallel);
		System.out.println("Esto NO funciona correctamente en paralello porque la operacion (num1 + num2)/2 NO es ASOCIATIVA");
		
		System.out.println("---------------CASO 6 INCORRECTO-----------------");
		int reductionMaxNeg = reduce(intsfornegartive, 0, max);
		System.out.println("Maximo de todos los elementos de la lista con negativos: "+ reductionMaxNeg);
		
		int reduction1MaxNeg = reduce(ints1fornegartive, 0, max);
		int reduction2MaxNeg = reduce(ints2fornegartive, 0, max);
		int reductionMaxNegParallel = reduce(Arrays.asList(reduction1MaxNeg,reduction2MaxNeg), 0, max);
		System.out.println("Maximo de todos los elementos de la lista con negativos paralelos: "+ reduction2MaxNeg);
		System.out.println("Esto NO funciona correctamente en paralello porque la operacion Maximo NO TIENE IDENTITY ELEMENT");
		
	}

	private static int reduce(List<Integer> ints, int i, BinaryOperator<Integer> operation) {
		int entityValue = i;
		for (Integer value : ints) {
			entityValue = operation.apply(entityValue, value);
		}
		return entityValue;
	}

}
