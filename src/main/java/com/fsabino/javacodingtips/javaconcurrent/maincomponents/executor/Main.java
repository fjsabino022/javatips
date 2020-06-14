package com.fsabino.javacodingtips.javaconcurrent.maincomponents.executor;

import java.util.concurrent.Executor;

public class Main {
    public static void main(String[] args) {
        // these task are synchronous
        Executor executor = new Invoker();
        executor.execute(() -> System.out.println("Invoker"));
        executor.execute(() -> System.out.println("Invoker 2"));
        executor.execute(() -> System.out.println("Invoker 3"));
    }
}
