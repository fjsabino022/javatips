package com.fsabino.javacodingtips.javacertification.pretest;

public class Deer {

    // este metodo se ejecutara porque se contruye la clase cuando se ejecuta el main
    public Deer() {
        System.out.print("Deer");
    }

    public Deer(int age) {
        System.out.print("DeerAge");
    }

    // este metodo se va a ejecutar porque Reinder es una herencia de Deer
    // y estamos ejecutando el metodo de deer
    private boolean hasHorns() {
        return false;
    }

    public static void main(String[] args) {
        Deer deer = new Reindeer(5);
        System.out.println("," + deer.hasHorns());
    }
}
