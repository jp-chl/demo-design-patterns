package com.jpvr.demodesignpatterns.dp.structural.decorator;

public abstract class SandwichDecorator implements Sandwich {

    protected Sandwich customSandwich;

    // Composition
    public SandwichDecorator(Sandwich customSandwich) {
        this.customSandwich = customSandwich;
    } // end constructor

    //@Override
    public String make() {
        return customSandwich.make();
    } // end String make()
} // end abstract class SandwichDecorator implements Sandwich
