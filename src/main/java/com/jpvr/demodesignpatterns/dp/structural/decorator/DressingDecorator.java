package com.jpvr.demodesignpatterns.dp.structural.decorator;

public class DressingDecorator extends SandwichDecorator {

    public DressingDecorator(Sandwich customSandwich) {
        super(customSandwich);
    }

    @Override
    public String make() {
        return customSandwich.make() + addDressing();
    } // end

    private String addDressing() {

        return " + mustard";
    } // end String addDressing()


} // end class DressingDecorator extends SandwichDecorator
