package com.fsabino.javacodingtips.lambda.BiFunction;

public class Main {

    public static void main(String[] args) {

        ExampleService exampleService = new ExampleService(0);
        exampleService.sumar("dummyorder", "home");
        exampleService.sumarSame("dummyorder", "home");
    }
}
