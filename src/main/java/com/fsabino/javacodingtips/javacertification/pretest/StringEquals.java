package com.fsabino.javacodingtips.javacertification.pretest;

public class StringEquals {

    public static void main(String[] main) {
        String s1 = "Java";
        String s2 = "Java";
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Ja").append("va");

        // sera true porque los dos string se guardan en la misma parte de memoria, string pool
        System.out.println(s1 == s2);

        // sera true porque estamos comparando contenido con el equals
        System.out.println(s1.equals(s2));

        // sera false porque estamos comparando un .tostring de un objeto
        // nuevo contra la referencia de memoria de otro objeto
        // stringbuilder genera una nueva instancia del string
        System.out.println(sb1.toString() == s1);

        // sera true porque estamos usando equals
        System.out.println(sb1.toString().equals(s1));
    }
}
