package javatips.fsabino.collections_framework.collection.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedVsArray {

    public static void main(String[] args) {
        // add
        executeAdd(0);
        executeAdd(500000);
        executeAdd();

        // get
        executeGet(0);
        executeGet(500000);
        executeGet(999999);
    }

    private static void executeAdd(int position) {
        List<Persona> listaarray = new ArrayList<>();
        List<Persona> listalinked = new LinkedList<>();
        long antes;
        for (int i = 0; i < 1000000; i++) {
            listaarray.add(new Persona(i, "Person" + i, i));
            listalinked.add(new Persona(i, "Person" + i, i));
        }
        System.out.println("Insert a new person into ArrayList (nanoseconds) position: " + position);
        antes = System.nanoTime();
        // insert into position 0
        listaarray.add(position, new Persona(10001, "Prueba", 10001));
        System.out.println(System.nanoTime() - antes);
        System.out.println("Insert a new person into LinkedList (nanoseconds) position: " + position);
        antes = System.nanoTime();
        // insert into position 0
        listalinked.add(position, new Persona(10001, "Prueba", 10001));
        System.out.println(System.nanoTime() - antes);
    }

    private static void executeAdd() {
        List<Persona> listaarray = new ArrayList<>();
        List<Persona> listalinked = new LinkedList<>();
        long antes;
        for (int i = 0; i < 1000000; i++) {
            listaarray.add(new Persona(i, "Person" + i, i));
            listalinked.add(new Persona(i, "Person" + i, i));
        }
        System.out.println("Insert a new person into ArrayList (nanoseconds)");
        antes = System.nanoTime();
        // insert into position
        listaarray.add(new Persona(10001, "Prueba", 10001));
        System.out.println(System.nanoTime() - antes);

        System.out.println("Insert a new person into LinkedList (nanoseconds)");
        antes = System.nanoTime();
        // insert into position
        listalinked.add(new Persona(10001, "Prueba", 10001));
        System.out.println(System.nanoTime() - antes);
    }

    private static void executeGet(int position) {
        List<Persona> listaarray = new ArrayList<>();
        List<Persona> listalinked = new LinkedList<>();
        long antes;
        for (int i = 0; i < 1000000; i++) {
            listaarray.add(new Persona(i, "Person" + i, i));
            listalinked.add(new Persona(i, "Person" + i, i));
        }
        System.out.println("Get a person into ArrayList (nanoseconds) position: " + position);
        antes = System.nanoTime();
        // get into position
        Persona p0 = listaarray.get(0);
        Persona p = listaarray.get(position);
        System.out.println(System.nanoTime() - antes);

        System.out.println("Get a person into into LinkedList (nanoseconds) position: " + position);
        antes = System.nanoTime();
        // get into position
        Persona pLinked0 = listalinked.get(0);
        Persona pLinked = listalinked.get(position);
        System.out.println(System.nanoTime() - antes);
    }
}
