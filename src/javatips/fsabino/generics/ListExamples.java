package javatips.fsabino.generics;

import java.util.ArrayList;
import java.util.List;

public class ListExamples {

    public static void main(String[] args) {

        Person p1 = new Person("Franco", 28);
        Person p2 = new Person("Belen", 24);

        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);

        System.out.println(people);
        System.out.println(people.size());
        System.out.println(people.get(0));

        final Person person = people.get(0);
        System.out.println(person);

        // without diamont operator
        List<String> raws = new ArrayList();

        /*
        *   Even though the compiler still allows us to use raw types in the constructor, it will prompt us with a warning message:
            ArrayList is a raw type. References to generic type ArrayList<E> should be parameterized
        * */

        /*
        * The diamond operator – introduced in Java 1.7 – adds type inference and reduces the verbosity in the assignments – when using generics:
        * */
        List<String> cars = new ArrayList<>();
    }
}
