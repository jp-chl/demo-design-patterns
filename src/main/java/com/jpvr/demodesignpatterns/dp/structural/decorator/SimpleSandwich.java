package com.jpvr.demodesignpatterns.dp.structural.decorator;

/**
 * Concrete implementation of interface
 */
public class SimpleSandwich implements Sandwich {

    @Override
    public String make() {
        return "Simple Sandwich made of Bread";
    } // end String make()
} // end class SimpleSandwich
