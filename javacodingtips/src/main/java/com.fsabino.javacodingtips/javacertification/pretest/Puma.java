package com.fsabino.javacodingtips.javacertification.pretest;

abstract class Puma implements HasTail {

    // este metodo no puede ser protected, porque el metodo de la interfaz es publico
    // no podemos bajar el nivel de visibilidad
    @Override
    public int getTailLength() {
        return 0;
    }
}
