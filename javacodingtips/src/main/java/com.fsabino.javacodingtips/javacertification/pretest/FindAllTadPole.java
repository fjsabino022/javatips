package com.fsabino.javacodingtips.javacertification.pretest;

import java.util.ArrayList;
import java.util.List;

public class FindAllTadPole {
    public static void main(String[] args) {
        List<Tadpole> tadpoles = new ArrayList<>();
        for (Amphibian amphibian : tadpoles) {
            Object tadpole = amphibian;
            // could be Amphibian, CanSwim and Object
        }
    }
}
