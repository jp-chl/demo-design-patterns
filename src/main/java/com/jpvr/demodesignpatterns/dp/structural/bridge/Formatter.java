package com.jpvr.demodesignpatterns.dp.structural.bridge;

import java.util.List;

public interface Formatter {

    String format(String header, List<Detail> details);
} // end interface Formatter
