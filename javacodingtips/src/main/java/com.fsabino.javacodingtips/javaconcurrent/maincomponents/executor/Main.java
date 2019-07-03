package com.fsabino.javacodingtips.javaconcurrent.maincomponents.executor;

public class Main {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.execute(() -> System.out.println("Invoker"));
        invoker.execute(() -> System.out.println("Invoker 2"));
        invoker.execute(() -> System.out.println("Invoker 3"));
    }
}
