package javatips.fsabino.generics;

import java.util.HashMap;
import java.util.Map;

public class MapExamples {
    public static void main(String[] args) {
        Person p1 = new Person("Franco", 28);
        Person p2 = new Person("Belen", 24);

        Map<String, Person> people = new HashMap<>();
        people.put(p1.getName(), p1);
        people.put(p2.getName(), p2);
        people.put(p1.getName(), p1); // is not appear because map is not allow you to have duplicate elements.

        for (Map.Entry<String, Person> entry : people.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
