package javatips.fsabino.generics;

import static java.util.Objects.requireNonNull;

public class Person {

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = requireNonNull(name);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
