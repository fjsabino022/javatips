package com.fsabino.javacodingtips.important_tips.value_vs_reference;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Documentation: https://www.baeldung.com/java-pass-by-value-or-pass-by-reference
 */
public class PrimitivesUnitTest {

    @Test
    public void whenModifyingPrimitives_thenOriginalValuesNotModified() {

        int x = 1;
        int y = 2;

        // Before Modification
        assertEquals(x, 1);
        assertEquals(y, 2);

        modify(x, y);

        // After Modification
        assertEquals(x, 1);
        assertEquals(y, 2);
    }

    public static void modify(int x1, int y1) {
        x1 = 5;
        y1 = 10;
    }
}
