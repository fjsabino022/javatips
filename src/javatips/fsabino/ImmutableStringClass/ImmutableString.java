package javatips.fsabino.ImmutableStringClass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ImmutableString {

    @Test
    public void testStringImmutable() {
        String s1 = "Hello World";
        String s2 = "Hello World";

        // two references (s1 & s2) point at the same string
        assertTrue(s1 == s2);
    }

    @Test
    public void testStringImmutableExample2() {

        String s1 = "Hello";
        String s2 = s1;
        // s1 and s2 now point at the same string - "Hello"

        s1 = "Help!";
        assertEquals("Help!", s1);

        // s2 still prints "Hello"
        assertEquals("Hello", s2);

        // Here we see the difference between mutating an object, and changing a reference.
        // s2 still points to the same object as we initially set s1 to point to.
        // Setting s1 to "Help!" only changes the reference, while the String object it originally referred to remains unchanged.

        /*
        * If strings were mutable, we could do something like this:

        String s1 = "Hello";
        String s2 = s1;
        s1.setCharAt(1, 'a');  Fictional method that sets character at a given pos in string
        System.out.println(s2);  Prints "Hallo"
        * */
    }
}
