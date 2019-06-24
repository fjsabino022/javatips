package com.fsabino.javacodingtips.javacertification.pretest;

import com.google.common.collect.ImmutableList;

public class ChickenSong {

    public static void main(String[] args) {

        HenHouse house = () -> ImmutableList.<Chicken>builder()
                .add(new Chicken())
                .add(new Chicken())
                .add(new Chicken())
                .build();
        Chicken chicken = house.getChickens().get(0);
        for (int i = 0; i < house.getChickens().size(); chicken = house.getChickens().get(i++)) {
            System.out.println("Cluck");
        }
    }
}


