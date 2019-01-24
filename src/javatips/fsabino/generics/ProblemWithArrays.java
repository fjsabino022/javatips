package javatips.fsabino.generics;

import java.util.Arrays;

public final class ProblemWithArrays {

    public static void main(String[] args) {

        Person pFranco = new Person("Franco", 22);
        Person pTomas = new Person("Tomas", 22);

        Person[] people = {pFranco, pTomas};

        // dont show "tostring" for the objects
        System.out.println(people);

        // we have to use Arrays.toString
        System.out.println(Arrays.toString(people));

        Person pBelen = new Person("Belen", 23);

        // we mustn't add an element because the lenght of array has been defined.
        //people[2] = pBelen;

        // we have to add manually a new element for the array
        people = add(pBelen, people);

        System.out.println(Arrays.toString(people));
    }

    private static Person[] add(final Person pBelen, Person[] people) {
        final int l = people.length;
        people = Arrays.copyOf(people, l + 1);
        people[l] = pBelen;
        return people;
    }
}
