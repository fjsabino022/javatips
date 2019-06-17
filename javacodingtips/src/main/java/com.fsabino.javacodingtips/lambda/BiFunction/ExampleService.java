package com.fsabino.javacodingtips.lambda.BiFunction;

import java.io.File;
import java.util.function.BiFunction;

public class ExampleService {

    private Integer somevalue;

    public ExampleService(Integer value) {
        this.somevalue = value;
    }

    private void process(String filename, String path, BiFunction<Integer, String, Integer> function) {
        System.out.println("Process -> Name= " + filename + " Path=" + path);
        String normalize = path +  File.separator + filename;

        if (function.apply(this.somevalue, normalize) > 0) {
            System.out.println("Process -> Valor Positivo");
        } else {
            System.out.println("Process -> Valor Negativo o 0");
        }
    }

    void sumar(String filename, String path) {
         System.out.println("Sumar -> Enter");
         filename += "SUMAR";
         this.process(filename, path, (suma, fullpath) -> {
             System.out.println(fullpath + File.separator +10 );
            return suma + 10;
         });
     }

     // is as equal as
    void sumarSame(String filename, String path) {
        System.out.println("Sumar -> Enter");
        filename += "SUMAR";

        BiFunction<Integer, String, Integer> function = (suma, fullpath) -> {
            System.out.println(fullpath + File.separator + 10);
            return suma + 10;
        };

        this.process(filename, path, function);
    }
}
