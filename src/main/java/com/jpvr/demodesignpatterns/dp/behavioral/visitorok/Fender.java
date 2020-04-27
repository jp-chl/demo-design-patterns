package com.jpvr.demodesignpatterns.dp.behavioral.visitorok;

public class Fender implements AtvPart {

    @Override
    public void accept(AtvPartVisitor visitor) {

        visitor.visit(this);
    } // end void accept(AtvPartVisitor visitor)
} // end class Fender implements AtvPart
