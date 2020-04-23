package com.jpvr.demodesignpatterns.reflection;

public class Logger {

    private String value;

    public Logger(String value) {
        this.value = value;
    } // end Logger(String value)

    public void log() {
        System.out.println("value = " + value);
    } // end void log()
} // end class Logger
