package com.fsabino.javacodingtips.javacertification.pretest;

public class Grasshopper {

    public Grasshopper(String n) {
        name = n;
    }

    public static void main(String[] args) {
        Grasshopper one = new Grasshopper("g1");
        Grasshopper two = new Grasshopper("g2");
        one = two; // a one se le asigna el objeto two, tienen la referencia al mismo objeto
        two = null; // two is null pero one sigue existiendo
        one = null; // el primero pasa a ser null
    }

    private String name;
}
