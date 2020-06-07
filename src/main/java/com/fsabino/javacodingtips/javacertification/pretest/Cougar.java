package com.fsabino.javacodingtips.javacertification.pretest;

public class Cougar extends Puma {

    public static void main(String[] args) {
        // Puma puma = new Puma(); no se puede porque puma es abstracta
        //System.out.println(puma.getTailLength());
    }

    public int getTailLength(int length) {
        return 2;
    }
}
