package com.fsabino.javacodingtips.javacertification.pretest;

public class MathFunctions {
    public static void addToInt(int x, int amountToAdd) {
        x = x + amountToAdd;
    }
    public static void main(String[] args) {
        int a = 15;
        int b = 10;
        MathFunctions.addToInt(a, b);
        System.out.println(a);
    }
    // imprime 15 porque el metodo addToInt no devuelve nada, y al ser tipos
    // de datos primitivos el valor de los argumentos es copiado
}
