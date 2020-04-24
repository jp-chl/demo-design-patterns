package com.jpvr.demodesignpatterns.dp.structural.bridge;

import java.util.List;

public abstract class Printer {

    public String print(Formatter formatter) {

        return formatter.format(getHeader(), getDetails());
    } // end String print(Formatter formatter)

    protected abstract List<Detail> getDetails();

    protected abstract String getHeader();

} // end abstract class Printer
