package javatips.fsabino.generics.classes_interfaces;

import javatips.fsabino.generics.Person;
import javatips.fsabino.generics.classes_interfaces.AgeComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> people = new ArrayList<>();
        people.add(donDraper);
        people.add(peggyOlson);
        people.add(bertCooper);

        System.out.println(people);

        // order collections use interface comparator by generics. (age)
        Collections.sort(people, new AgeComparator());

        System.out.println(people);

        // order collections use interface comparator by generics. (reverse age)
        Collections.sort(people, new ReverseComparator<>(new AgeComparator()));

        System.out.println(people);
    }
}
