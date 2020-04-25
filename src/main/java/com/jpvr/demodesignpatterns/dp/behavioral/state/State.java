package com.jpvr.demodesignpatterns.dp.behavioral.state;

public abstract class State {

    public void handleRequest() {

        System.out.println("Shouldn't be able to get here.");
        //throw new IllegalAccessException();
        //throw new IllegalStateException();
    } // end void handleRequest()
} // end abstract class State
