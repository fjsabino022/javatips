package com.fsabino.javacodingtips.patterns_of_design.structural.bridge;

import java.util.List;

public abstract class Printer {

    // method invoke interface
    public String format (Formatter formatter) {
        return formatter.format(getHeader(), getDetails());
    }

    abstract protected String getHeader();
    abstract protected List<Detail> getDetails();
}
