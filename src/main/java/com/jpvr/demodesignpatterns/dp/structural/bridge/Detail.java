package com.jpvr.demodesignpatterns.dp.structural.bridge;

public class Detail {

    private String label;
    private String value;

    public Detail(String label, String value) {
        this.label = label;
        this.value = value;
    } // end constructor

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }
} // end class Detail
