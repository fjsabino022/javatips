package javatips.fsabino.generics.classes_interfaces;

import javatips.fsabino.generics.Person;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person l, Person r) {
        return Integer.compare(l.getAge(), r.getAge());
    }
}
