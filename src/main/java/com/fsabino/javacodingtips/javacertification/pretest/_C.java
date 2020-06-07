package com.fsabino.javacodingtips.javacertification.pretest;

public class _C {

    // se permite simbolo peso como nombre de variable
    // esta variable no esta inicializada, pero sera 0 en caso de que se intente imprimir
    private static int $;

    // como String no es un tipo de dato primitivo entonces sera null en el caso que se quiera imprimir
    // pero no arrojara error de compilacion si es que se quiere imprimir
    private static String $2;

    public static void main(String[] main) {
        String a_b; // es una variable local, si o si necesita ser inicializada
        System.out.print($); //imprimira 0
        System.out.print($2);

        // error de compilacion porque es una variable local que no esta inicilizada
        // System.out.print(a_b);
    }
}
