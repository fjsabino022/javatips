package com.fsabino.javacodingtips.validations;

import org.junit.Test;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class TestValidation {

    @Test
    public void test_with_null() {
        sum(null);
    }

    private int sum(@Valid @NotNull Integer value) {

        if (value == null) {
            System.out.println("Value is null");
        }

        return 5 + value;
    }
}
