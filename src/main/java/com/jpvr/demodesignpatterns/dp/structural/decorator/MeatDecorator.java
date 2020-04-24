package com.jpvr.demodesignpatterns.dp.structural.decorator;

public class MeatDecorator extends SandwichDecorator {

    public MeatDecorator(Sandwich customSandwich) {
        super(customSandwich);
    } // end constructor

    @Override
    public String make() {
        return customSandwich.make() + addMeat();
    } // end String make()

    private String addMeat() {
        return " + turkey";
    } // end String addMeat()

} // end class MeatDecorator extends SandwichDecorator
