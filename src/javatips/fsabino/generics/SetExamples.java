package javatips.fsabino.generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetExamples {

    public static void main(String[] args) {

        Person p1 = new Person("Franco", 28);
        Person p2 = new Person("Belen", 24);

        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);

        System.out.println(people);
        System.out.println(people.size());
        System.out.println(people.get(0));

        Set<Person> setPeople = new HashSet<>();
        setPeople.add(p1);
        setPeople.add(p2);
        setPeople.add(p1); // set only show one person p1. is not allow you duplicate elements.

        System.out.println(people);
        System.out.println(people.size());

        // is not contain get method
        //setPeople.get(0)

        // set is not mantein the order of the elements.
    }

}
